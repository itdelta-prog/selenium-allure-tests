# selenium-allure-tests

# Environment
OpenJDK 11.0.16

Allure 2.18.1

# Run tests
mvn clean test -DsuiteXmlFile=testng.xml 

# Clear results
rm -r allure-results/ || true

# Show results
allure serve /path/to/allure-results
