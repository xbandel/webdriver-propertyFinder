Here is the test for propertyfinder site (question 4). To solve it I used the Selenium WebDriver + Java, created the maven project. To run this test you need to do the following:

1. Install maven
https://maven.apache.org/download.cgi

2. Install Java 8
http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html

3. Install Chrome driver, note the path to executable chrome driver file
https://sites.google.com/a/chromium.org/chromedriver/downloads

4. run test cases from command line using the following command:
mvn test -Dwebdriver.chrome.driver=<path to executable chrome driver file>
set the path to you executable chrome driver file 
for example, mvn test -Dwebdriver.chrome.driver=/home/user/tmp/chromedriver
