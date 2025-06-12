# 🚀 Selenium Test Automation Framework

A robust, scalable, and maintainable test automation framework built with Selenium WebDriver, TestNG, and Java. This framework implements industry best practices and design patterns to ensure efficient test automation.

## 🌟 Key Features

- **Page Object Model (POM)** design pattern for better maintainability
- **Thread-safe WebDriver** implementation for parallel test execution
- **ExtentReports** and **Allure Reports** for comprehensive test reporting
- **Log4j** integration for detailed logging
- **Retry Mechanism** for failed tests
- **Screenshot Capture** on test failures
- **Data-Driven Testing** support using Apache POI
- **Cross-Browser Testing** capabilities
- **Maven** for dependency management and build automation

## 🛠 Tech Stack

| Technology | Version | Purpose |
|------------|---------|----------|
| Java | 17 | Programming Language |
| Selenium WebDriver | 4.32.0 | Web Automation |
| TestNG | 7.11.0 | Test Framework |
| Maven | Latest | Build Tool |
| ExtentReports | 2.41.2 | HTML Reporting |
| Allure Reports | 2.29.1 | Advanced Reporting |
| Log4j | 1.2.17 | Logging |
| Apache POI | 3.9 | Excel Operations |
| OpenCSV | 5.9 | CSV Operations |

## 📁 Project Structure

```
DemoFramework_of_selenium/
├── src/
│   ├── main/
│   │   └── java/
│   │       └── utils/            # Utility classes
│   │           ├── ConfigManager.java
│   │           ├── Waits.java
│   │           └── ...
│   └── test/
│       └── java/
│           ├── base/            # Base classes
│           │   └── TestBase.java
│           ├── pages/           # Page Objects
│           │   ├── LoginPage.java
│           │   └── ...
│           ├── tests/           # Test Classes
│           │   ├── LoginTest.java
│           │   └── ...
│           └── listeners/       # Test Listeners
│               ├── RetryAnalyzer.java
│               └── TestListener.java
├── TestRunner/
│   └── testng.xml              # Test Suite Configuration
├── test-output/                # Test Reports
├── screenshots/                # Failure Screenshots
├── pom.xml                     # Maven Configuration
└── README.md
```

## 🚀 Getting Started

### Prerequisites

- Java JDK 17 or higher
- Maven
- Chrome/Firefox browser
- IDE (IntelliJ IDEA or Eclipse)

### Installation

1. Clone the repository:
   ```bash
   git clone https://github.com/RajaHassanX36/DemoFramework_of_selenium.git
   cd DemoFramework_of_selenium
   ```

2. Import the project in your IDE:
   - Open IntelliJ IDEA/Eclipse
   - Import as Maven project
   - Wait for dependencies to download

3. Configure the project:
   - Update `config.properties` with your test environment details
   - Ensure WebDriver binaries are in the correct location

### Running Tests

1. Run all tests:
   ```bash
   mvn clean test
   ```

2. Run specific test class:
   ```bash
   mvn test -Dtest=LoginTest
   ```

3. Run specific test suite:
   ```bash
   mvn test -DsuiteXmlFile=TestRunner/testng.xml
   ```

## 📊 Reports

### Extent Reports
- Location: `test-output/ExtentReport.html`
- Features:
  - Detailed test execution summary
  - Test steps with screenshots
  - Pass/Fail statistics
  - Execution time

### Allure Reports
- Generate report:
  ```bash
  mvn allure:serve
  ```
- Features:
  - Interactive dashboard
  - Test execution timeline
  - Environment details
  - Test categories

## 🛠 Framework Customization

### Adding New Tests
1. Create a new page class in `src/test/java/pages/`
2. Create corresponding test class in `src/test/java/tests/`
3. Add test methods using TestNG annotations

### Configuration
- Update `config.properties` for:
  - Environment URLs
  - Browser settings
  - Timeouts
  - Test data

### Adding Dependencies
- Add new dependencies in `pom.xml`
- Run `mvn clean install` to update

## 🤝 Contributing

1. Fork the repository
2. Create your feature branch (`git checkout -b feature/AmazingFeature`)
3. Commit your changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

## 📝 License

This project is licensed under the MIT License - see the LICENSE file for details.

## 👥 Authors

- **Raja Hassan** - *Initial work* - [RajaHassanX36](https://github.com/RajaHassanX36)

## 🙏 Acknowledgments

- Selenium WebDriver team
- TestNG team
- All contributors and users of this framework
