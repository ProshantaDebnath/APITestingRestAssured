📘 RestAssured E2E Automation Framework

🚀 Overview
This project is a Java‑based End‑to‑End API Automation Framework built using RestAssured and integrated with TestNG for test execution. It is designed to be modular, scalable, and CI/CD‑ready, enabling teams to validate APIs efficiently across environments.

🛠 Tech Stack
- Java (Core language)
- RestAssured (API automation)
- TestNG (Test execution & reporting)
- Maven (Build & dependency management)
- Extent Reports / Allure Reports (Rich reporting)
- GitHub Actions / Jenkins (CI/CD integration)

📂 Project Structure
E2E-Automation-Framework/
│── src/main/java/        # Core framework utilities
│── src/test/java/        # Test cases
│── src/test/resources/   # Config files, test data
│── target/               # Build output
│── test-output/          # TestNG reports
│── allure-results/       # Allure report data
│── extent-reports/       # Extent report output
│── pom.xml               # Maven dependencies
│── .gitignore            # Git ignore rules


⚙️ Features
- ✅ Reusable API methods (GET, POST, PUT, DELETE)
- ✅ Configurable base URLs & environments
- ✅ Data‑driven testing with JSON/XML payloads
- ✅ Custom assertions & validations
- ✅ Integrated reporting (Extent & Allure)
- ✅ CI/CD ready with Jenkins/GitHub Actions
- ✅ Scalable design for adding new modules


▶️ Getting Started
1. Clone the repo
git clone https://github.com/your-username/restassured-e2e-framework.git

2. Install dependencies
mvn clean install

3. Run tests
mvn test

4. Generate reports
- TestNG Report: test-output/index.html
- Allure Report:
allure serve allure-results


📊 CI/CD Integration
- Jenkins: Configure Maven build steps and publish reports.
- GitHub Actions: Add workflows to run tests on push/pull requests.

📝 Contribution Guidelines
- Fork the repo and create feature branches.
- Follow naming conventions for test cases.
- Ensure all new tests are added to the suite and validated.
