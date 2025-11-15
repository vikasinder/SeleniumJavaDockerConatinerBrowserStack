package Day1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.beust.jcommander.Parameter;

import Utilities.DriverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass_BrowserSetup {

	// Properties File ..Reading Configuration Data
     public static Properties prop;

	
     
     WebDriver driver;
	    
	    
		//loadConfig method is to load the configuration
		@BeforeSuite(groups = { "Smoke", "Sanity", "Regression" })
		//LoadConfig method is under Before suite annotation , so this method runs automatically
		public void loadConfig() {
			//ExtentManager.setExtent();
			//DOMConfigurator.configure("log4j.xml");

			try {
				prop = new Properties();
				FileInputStream ip = new FileInputStream(
						System.getProperty("user.dir") + "\\Configuration\\Config.properties");
				prop.load(ip);

			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		
		///mvn clean test -DTEST_ENV=PROD -Dbrowser=IE
		//-Dbrowser=IE → creates a JVM system property called browser
		
		//-DTEST_ENV=PROD → creates a JVM system property called TEST_ENV

		//✅ These are NOT OS environment variables.

		//	They exist only inside the JVM process that Maven launches for your test run.

		//🧩 2. What your code currently does
		//public String getEnvironment() {
		//String env = System.getenv("TEST_ENV");  // 👈 reads OS-level env var
		//if (env == null) {
       // env = "QA";
		//}
		//return env;
		//}
		//This method only checks OS environment variables — i.e., those defined permanently in your system (like setx TEST_ENV QA on Windows or export TEST_ENV=QA in Linux).
		//So if you’re not setting that at the OS level, and you’re only using -DTEST_ENV=PROD, then System.getenv("TEST_ENV") will return null.
		//➡️ Meaning your getEnvironment() method will fall back to "QA".
		
		
		
		/*Priority	Source	Method Used	Example
		1️⃣	Command-line (Maven/Jenkins -D)		||	System.getProperty("browser") /System.getProperty("environment") ||	mvn clean test -Dbrowser=IE -Denvironment=PROD
		2️⃣	TestNG XML parameters	            ||browserNameFromXML, environmentFromXML	                         ||<parameter name="browser" value="chrome"/>
		3️⃣	Config.properties file	            ||prop.getProperty("browser")										 ||browser=chrome
		4️⃣	Default hardcoded fallback	"Chrome", "QA"	in your code
		
		public String getEnvironment() {
			
			// This is when you have hard coded env value and you are fetching env variable from there
		    String env = System.getenv("TEST_ENV"); // fetch environment variable
		    if(env == null) {
		        env = "QA"; // default environment if none is set
		    }
		    return env;
		}*/
		
		// OPTION 1
		
		/// From Command Prompt One Time Setup
		///
		/// Running Test based upon Enviornment Variable From Command Prompt
		///// One Time SetUp
		///C:\Users\vikas\VikasPractiseNew>set TEST_ENV=QA
		///C:\Users\vikas\VikasPractiseNew>mvn test
		
		//// OPTION 2
		
		
		//Hard Coding Enviornment Variable 
		// Go to env variable option is system and change variable to point to particular Enviornmenet
		
		
		///  YOU CAN ALSO DO IT FROM POX.XML , BY SENDING ENV AS PARAMETER
		///
		///
		///Variable	Example values	Purpose
		///TEST_ENV	QA / STAGE / PROD	Determines which URL to open (app under test)
		///EXECUTION_ENV	local / docker / browserstack	Determines where to run the test
		
	@BeforeMethod
	// THESE PARAMETERS ARE READ FROM TESTNG FILE ONLY ( PARAMETER TAG ) ..NOT THE ONES YOU SEND FROM COMMAND LINE
	@Parameters({"browser", "Test_ENV_TestngFile", "Execution_ENV_TestNgFile" , "OS"})
	//@Parameters("browser")
	  //  public void browserSetUp() 
	
	// Sending Enviornment variable from TestNG.xml
	    public void browserSetUp(@Optional("chrome") String browserNameFromXML , @Optional("QA") String environmentFromXML,
	    		@Optional("local") String executionEnvironment, String opertaingSystem) throws Exception
	{
		// Opening Browser before each test
		  System.out.println("This is Before Method");
		  // This is when we are running from Config Properties File as its value is coiming from PROP file : prop.getProperty("Browser")
		  //String browserName=prop.getProperty("Browser");
		  
		  
		  /// Using this command : mvn clean test -DTEST_ENV=PROD -Dbrowser=IE
		  /// Two values are set browser and TEST_ENV from command line  :  THEN VALUES COMES IN SYSTEM.GETPROPERTY()
		  ///
		  ///OPTION2
		  ///IF ENV VARIABLE IS SET : THEN RUN IT FROM TESTNG.XML AND VALUES COMES IN SYSTEM.GETENVIORNMENT()
		  ///
		  ///OPTION 3
		  ///IF PROP.GETPROPERTY : THEN VALUE IS COMING FROM CONFIGURATION FILE 
		  
		// Step 1: Command line or Jenkins parameter  : One time enviornment Variable
		  // when we do : 
		   // THESE ARE THE PARAMETERS WE SEND FROM COMMAND LINE - THESE ARE KNOWN AS SYSTEM PROPERTIES
		  
		  System.out.println("=== Starting Browser Setup ===");
		  	
		  	String browser = System.getProperty("browser");
		    String test_environment = System.getProperty("TEST_ENV_CMD_LINE");  // QA/PROD/STAGE
		    String execEnv = System.getProperty("EXECUTION_ENV_CMD_LINE"); // local/docker/browserstack
		    // Step 2: If not provided via command line, take from XML
		    
		    if (browser == null || browser.isEmpty())
		        browser = browserNameFromXML;
		    if (test_environment == null || test_environment.isEmpty())
		    	test_environment = environmentFromXML;
		    if (execEnv == null || execEnv.isEmpty())
		    	execEnv = executionEnvironment;

		    // Step 3: If not provided in XML, take from config file // There is no need for this code as you are passing
		    // optional values as defalut parameters // if they are empty then u can use it
		    if (browser == null || browser.isEmpty())
		        browser = prop.getProperty("browser", "Chrome");
		    if (test_environment == null || test_environment.isEmpty())
		    	test_environment = prop.getProperty("environment", "QA");
		    if (execEnv == null || execEnv.isEmpty())
		    	execEnv = prop.getProperty("execEnv", "local");

		    
		    System.out.println("✅ Final Browser: " + browser);
		    System.out.println("✅ Final Environment: " + test_environment);
		    
		    
		    
		    driver = initializeDriver(execEnv, browser , opertaingSystem);
		    DriverFactory.setDriver(driver);
		  
//		  if (browser.equalsIgnoreCase("Chrome")) {
//				WebDriverManager.chromedriver().setup();
//				// Set Browser to ThreadLocalMap
//				driver = new ChromeDriver();
//				DriverFactory.setDriver(driver);
//		        // or we can write setDriver(new ChromeDriver())
//
//			}
//			else if (browser.equalsIgnoreCase("FireFox")) {
//				WebDriverManager.firefoxdriver().setup();
//				driver = new FirefoxDriver();
//				DriverFactory.setDriver(driver);
//			}
//			else if (browser.equalsIgnoreCase("IE")) {
//				WebDriverManager.iedriver().setup();
//				driver = new InternetExplorerDriver();
//				DriverFactory.setDriver(driver);
//				
//			}
		  
		  
		  
		  	
			
			
			
			//Maximize the screen
		  	DriverFactory.getDriver().manage().window().maximize();
			//Delete all the cookies
		  	DriverFactory.getDriver().manage().deleteAllCookies();
			//Implicit TimeOuts

			Long waitTime = Long.parseLong(prop.getProperty("ImplicitWait"));
			Long waitTimePageTimeOut = Long.parseLong(prop.getProperty("pageloadtimeout"));
			DriverFactory.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(waitTime));
			DriverFactory.getDriver().manage().timeouts().pageLoadTimeout(Duration.ofSeconds(waitTimePageTimeOut));
			
			//PageLoad TimeOuts
			
//			getDriver().manage().timeouts().pageLoadTimeout
//			(Integer.parseInt(prop.getProperty("pageLoadTimeOut")),TimeUnit.SECONDS);
			
			
			//DriverFactory.getDriver().get(prop.getProperty("url"));
			
			//if we are sending from POM.XML  then we dont have to execute that env method
			
			//String env = getEnvironment();
			
			
			// You can HARDCODE enviornment variable and then run testng.xml file // it will run based upon enviornment set
			
			//DriverFactory.getDriver().navigate().to(prop.getProperty(env + ".url"));
			//either use get or Navigate()
			test_environment = test_environment.toUpperCase().trim();
			DriverFactory.getDriver().get(prop.getProperty(test_environment + ".url"));
			System.out.println("Running tests on environment: " + test_environment);
			
//	    	System.out.println("This is Before Class");
//	    	WebDriverManager.chromedriver().setup();
//	        driver = new ChromeDriver();
//	        setDriver(driver);
//
//	        getDriver().navigate().to("https://www.bacciano.com/home");
//	        getDriver().manage().window().maximize();
//
//	        // Initialize elements for base class (if any)
//	        System.out.println("Browser launched for thread: " + Thread.currentThread().getId());

	  }
	
	
	//// New Clear Model
	///
	///
	
	 public WebDriver initializeDriver(String executionEnvironment, String browser, String operatingSystem) throws Exception {

		 
		 // Here no assignment is done , we are just converting to lower case and re assigning to same variable
		 
	        executionEnvironment = executionEnvironment.toLowerCase();
	        browser = browser.toLowerCase();
	        operatingSystem = operatingSystem.toLowerCase();

	        // Decide which driver to initialize based on execution environment
	        switch (executionEnvironment) {
	        // Local Execution : Here we are passing only browser as we are running on local machine
	            case "local":
	                return initLocalDriver(browser);
	              // Docker/Selenium Grid Execution
	                // Here we are passing both browser and operating system as we have multiple OS available on docker
	            case "docker":
	            	
	                return initDockerDriver(browser, operatingSystem);
	                // BrowserStack Cloud Execution
	            case "browserstack":
	                return initBrowserStackDriver(browser,operatingSystem);

	            default:
	                throw new IllegalArgumentException("Unknown execution environment: " + executionEnvironment);
	        }
	    }

	    private WebDriver initLocalDriver(String browser) {
	        switch (browser) {
	            case "chrome":
	                WebDriverManager.chromedriver().setup();
	                return new ChromeDriver();
	            case "firefox":
	                WebDriverManager.firefoxdriver().setup();
	                return new FirefoxDriver();
	            case "ie":
	            case "internet explorer":
	                WebDriverManager.iedriver().setup();
	                return new InternetExplorerDriver();
	            default:
	                throw new IllegalArgumentException("Unsupported local browser: " + browser);
	        }
	    }

	    /// System Properties  >  Environment Variables  >  TestNG XML  >  Config.properties
	    ///
	    private WebDriver initDockerDriver(String browser, String operatingSystem) throws Exception {
	        String gridUrl = System.getProperty("GRID_URL",
	                prop.getProperty("grid.url", "http://localhost:4444"));
	        System.out.println("🐳 Connecting to Selenium Grid: " + gridUrl);

	        DesiredCapabilities caps = new DesiredCapabilities();

	        // Set platform based on your nodes
	        switch (operatingSystem) {
	            case "windows":
	                caps.setPlatform(Platform.WIN11);
	                break;
	            case "linux":
	                caps.setPlatform(Platform.LINUX);
	                break;
	            case "mac":
	                caps.setPlatform(Platform.MAC);
	                break;
	            default:
	                throw new IllegalArgumentException("Unsupported operating system: " + operatingSystem);
	        }

	        // Set browser
	        switch (browser) {
	            case "chrome":
	            case "firefox":
	                caps.setBrowserName(browser);
	                break;
	            default:
	                throw new IllegalArgumentException("Unsupported browser for Docker/Grid: " + browser);
	        }

	        return new RemoteWebDriver(new URL(gridUrl), caps);
	        
	        ///docker-compose up-d / docker ps / docker-compose down..so thses are the commands that are needed for docker to run
	        ///C:\Users\vikas\VikasPractiseNew>mvn clean test -Dbrowser=firefox -DTEST_ENV_CMD_LINE=PROD -DEXECUTION_ENV_CMD_LINE=docker -DGRID_URL=http://localhost:4444
	    }

	    
	    
	    ///ALTERNATE IF WE WANT TO CHOOSE FROM AVAIABLE OPERATIMG SYETEMS ON DOCKER
	    
//	    private WebDriver initDockerDriver(String requestedBrowser, String requestedOS) throws Exception {
//	        String gridUrl = System.getProperty("GRID_URL", prop.getProperty("grid.url", "http://localhost:4444"));
//	        System.out.println("🐳 Connecting to Selenium Grid: " + gridUrl);
//
//	        // Fetch Grid status JSON
//	        URL statusUrl = new URL(gridUrl + "/status");
//	        HttpURLConnection conn = (HttpURLConnection) statusUrl.openConnection();
//	        conn.setRequestMethod("GET");
//	        BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
//	        StringBuilder sb = new StringBuilder();
//	        String line;
//	        while ((line = reader.readLine()) != null) sb.append(line);
//	        reader.close();
//
//	        JSONObject gridStatus = new JSONObject(sb.toString());
//	        JSONArray nodes = gridStatus.getJSONObject("value").getJSONArray("nodes");
//
//	        // Try to find a matching node
//	        JSONObject chosenSlot = null;
//	        for (int i = 0; i < nodes.length(); i++) {
//	            JSONObject node = nodes.getJSONObject(i);
//	            JSONArray slots = node.getJSONArray("slots");
//	            for (int j = 0; j < slots.length(); j++) {
//	                JSONObject slot = slots.getJSONObject(j).getJSONObject("stereotype");
//
//	                String nodeBrowser = slot.getString("browserName").toLowerCase();
//	                String nodeOS = slot.getString("platformName").toLowerCase();
//
//	                if ((requestedBrowser == null || requestedBrowser.equalsIgnoreCase(nodeBrowser))
//	                        && (requestedOS == null || requestedOS.equalsIgnoreCase(nodeOS))) {
//	                    chosenSlot = slot;
//	                    break;
//	                }
//	            }
//	            if (chosenSlot != null) break;
//	        }
//
//	        if (chosenSlot == null) {
//	            throw new IllegalArgumentException("No matching browser/platform found in Grid for: "
//	                    + requestedBrowser + "/" + requestedOS);
//	        }
//
//	        // Set capabilities based on chosen slot
//	        DesiredCapabilities caps = new DesiredCapabilities();
//	        caps.setBrowserName(chosenSlot.getString("browserName"));
//	        caps.setPlatform(Platform.fromString(chosenSlot.getString("platformName").toUpperCase()));
//	        return new RemoteWebDriver(new URL(gridUrl), caps);
//	    }
//	    
	    
	   
	    
	    private WebDriver initBrowserStackDriver(String browser , String operatingSystem) throws Exception {
	        
	    	String bsUser = System.getProperty("BROWSERSTACK_USERNAME");
	    	String bsKey  = System.getProperty("BROWSERSTACK_ACCESS_KEY");
	    	
//	    	String bsUser = System.getenv("BROWSERSTACK_USERNAME");
//	        String bsKey = System.getenv("BROWSERSTACK_ACCESS_KEY");

	        if (bsUser == null) bsUser = prop.getProperty("browserstack.username");
	        if (bsKey == null) bsKey = prop.getProperty("browserstack.accesskey");
	        
	       

	        String bsUrl = "https://" + bsUser + ":" + bsKey + "@hub.browserstack.com/wd/hub";
	        System.out.println("☁️ Connecting to BrowserStack Cloud...");

	        DesiredCapabilities caps = new DesiredCapabilities();
	        caps.setCapability("browserName", browser);
	        
	        
	        if (operatingSystem == null || operatingSystem.isEmpty()) {
	            operatingSystem = "windows";  // Default
	        }
	     // --- Operating System Mapping ---
	        switch (operatingSystem.toLowerCase()) {
	        
	            case "windows":
	                caps.setCapability("os", "Windows");
	                caps.setCapability("osVersion", "11");  // you can change to 10 if needed
	                break;

	            case "mac":
	            case "macos":
	                caps.setCapability("os", "OS X");
	                caps.setCapability("osVersion", "Ventura"); // or Sonoma/Monterey
	                break;

	            case "linux":
	                throw new IllegalArgumentException("❌ BrowserStack does NOT support Linux desktop browsers.");
	                
	            default:
	                throw new IllegalArgumentException("Unsupported operating system: " + operatingSystem);
	        }

	        // Extra BrowserStack recommended capabilities
	        caps.setCapability("project", "Selenium Practice");
	        caps.setCapability("build", "Build #" + System.currentTimeMillis());
	        caps.setCapability("name", browser +"On Operting system "+ operatingSystem + " Test on BrowserStack");
	        
	        
	        return new RemoteWebDriver(new URL(bsUrl), caps);
	    }
	
	
	
//	public WebDriver initializeDriver(String executionEnviornment, String browser , String operatingSystem) throws Exception {
//
//        switch (executionEnviornment.toLowerCase()) {
//
//            case "local":
//                if (browser.equalsIgnoreCase("chrome")) {
//                    WebDriverManager.chromedriver().setup();
//                    return new ChromeDriver();
//                } else if (browser.equalsIgnoreCase("firefox")) {
//                    WebDriverManager.firefoxdriver().setup();
//                    return new FirefoxDriver();
//                } else if (browser.equalsIgnoreCase("ie")) {
//                    WebDriverManager.iedriver().setup();
//                    return new InternetExplorerDriver();
//                } else {
//                    throw new IllegalArgumentException("Unsupported browser for local: " + browser);
//                }
//
//            case "docker":
//                String gridUrl = System.getProperty("GRID_URL",
//                        prop.getProperty("grid.url", "http://localhost:4444"));
//                System.out.println("🐳 Connecting to Selenium Grid: " + gridUrl);
//
//                DesiredCapabilities dockerCaps = new DesiredCapabilities();
//                
//                if(operatingSystem.equalsIgnoreCase("windows"))
//                {
//                	dockerCaps.setPlatform(Platform.WIN11);
//                }
//                else if(operatingSystem.equalsIgnoreCase("linux"))
//                {
//                	dockerCaps.setPlatform(Platform.LINUX);
//                }
//                else if(operatingSystem.equalsIgnoreCase("mac"))
//                {
//                	dockerCaps.setPlatform(Platform.MAC);
//                }
//                else
//                {
//                	throw new IllegalArgumentException("No matching operating system: " + operatingSystem);
//                }
//                switch(browser.toLowerCase())
//                {
//                case "chrome" : dockerCaps.setBrowserName("chrome"); break;
//                case "firefox" : dockerCaps.setBrowserName("firefox"); break;
//                default: throw new IllegalArgumentException("No matching browser: " + browser);
//                }
//                
//                return new RemoteWebDriver(new URL(gridUrl), dockerCaps);
//                // This is Like Webdriver driver=new RemoteWebDriver(new URL(gridUrl), dockerCaps);
//            case "browserstack":
//                String bsUser = System.getenv("BROWSERSTACK_USERNAME");
//                String bsKey = System.getenv("BROWSERSTACK_ACCESS_KEY");
//
//                // fallback to config if env not set
//                if (bsUser == null) bsUser = prop.getProperty("browserstack.username");
//                if (bsKey == null) bsKey = prop.getProperty("browserstack.accesskey");
//
//                String bsUrl = "https://" + bsUser + ":" + bsKey + "@hub.browserstack.com/wd/hub";
//                System.out.println("☁️ Connecting to BrowserStack Cloud...");
//
//                DesiredCapabilities bsCaps = new DesiredCapabilities();
//                bsCaps.setCapability("browserName", browser);
//                bsCaps.setCapability("browserVersion", "latest");
//                bsCaps.setCapability("os", "Windows");
//                bsCaps.setCapability("osVersion", "11");
//                bsCaps.setCapability("project", "Selenium Practice");
//                bsCaps.setCapability("build", "Build #" + System.currentTimeMillis());
//                bsCaps.setCapability("name", browser + " Test on BrowserStack");
//
//                return new RemoteWebDriver(new URL(bsUrl), bsCaps);
//                // This is Like Webdriver driver=new RemoteWebDriver(new URL(bsUrl), bsCaps);
//
//            default:
//                throw new IllegalStateException("Unknown environment: " + executionEnviornment);
//        }
//    }

	    @AfterMethod
	    public void tearDown() {
	    	System.out.println("This is After Method");
	    	DriverFactory.getDriver().quit();
	        DriverFactory.tdriver.remove(); // Clean up thread-local to prevent memory leaks
	    }
	    
	    @AfterSuite(alwaysRun = true)
	    public void afterSuite() {
	        System.out.println("=== Test Suite Execution Completed ===");

	        // ✅ 1. Close Extent Report (if used)
	        // ExtentManager.endReport();

	        // ✅ 2. Close loggers (optional)
	        // DOMConfigurator.shutdown();

	        // ✅ 3. Optional: Add a summary message or custom cleanup
	        // Example: send report email, print results summary, etc.

	        System.out.println("All browsers closed successfully.");
	    }
}
