# 🚀 DemoFramework_of_selenium

A powerful, modular automation testing framework built with **Selenium WebDriver**, **TestNG**, **Java**, and **Maven**. It uses the **Page Object Model (POM)** design pattern and integrates **ExtentReports**, **Log4j**, and **ThreadLocal WebDriver** for efficient, parallel, and maintainable test automation.

---

## 🔧 Tech Stack

| Tool           | Purpose                              |
|----------------|--------------------------------------|
| Java           | Programming language                 |
| Selenium       | UI automation                        |
| TestNG         | Test orchestration                   |
| Maven          | Dependency management                |
| ExtentReports  | HTML test reports                    |
| Allure Reports | Advanced reporting (optional)        |
| Log4j          | Logging framework                    |
| ThreadLocal    | Parallel test execution support      |

---



## 📥 Getting Started

### 1. Clone the Repo

```bash
git clone https://github.com/RajaHassanX36/DemoFramework_of_selenium.git
cd DemoFramework_of_selenium


## 📁 Project Structure

DemoFramework_of_selenium/
├── src/
│   ├── main/
│   │   └── java/
│   │       └── utils/            # Utility classes (Waits, ConfigManager, etc.)
│   └── test/
│       └── java/
│           ├── base/            # TestBase: WebDriver & test setup
│           ├── pages/           # POM: Page classes
│           ├── tests/           # Test classes using TestNG
│           └── listeners/       # RetryAnalyzer, ITestListener for logs/screenshots
├── drivers/                     # ChromeDriver/GeckoDriver binaries (optional)
├── testng.xml                   # Test suite config
├── pom.xml                      # Maven dependencies
└── README.md
---

### 2. Import in IDE
Use IntelliJ or Eclipse
Import as a Maven project

##🧪 Features
✅ Page Object Model (POM) structure
🔁 Retry failed tests via RetryAnalyzer
📷 Screenshot capture on failure
📄 HTML reports with ExtentReports
🧵 Thread-safe WebDriver for parallel tests
🔍 Dynamic waits and reusable utility methods
📊 Reports
After test execution:
Extent Report:
Navigate to:
bash
/test-output/ExtentReport.html
Screenshots on Failure:
Captured under:
bash
/screenshots/
🛠 Sample Commands
Run a full suite:

```bash
mvn clean test -DsuiteXmlFile=testng.xml
Run a single test:

```bash
mvn test -Dtest=LoginTest
💡 Customization Tips
Update config.properties for environment URLs and credentials

Add new Page classes in pages/

Add test cases in tests/

Configure listeners in testng.xml or ServiceLoader

📬 Contribution
Feel free to fork this repo, improve it, and raise pull requests. Open issues if you face any problems.
