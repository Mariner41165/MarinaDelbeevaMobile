# MarinaDelbeevaMobile

Run one of the following commands and see how tests pass on mobilecloud.epam.com:

mvn clean test -PcloudAndroid - initializes native application test on device Google Pixel 5  

mvn clean test -PcloudIos - initializes native application test on device iPhone 8 Plus

mvn clean test -PcloudWeb - initializes web application test on device Google Pixel 2  

mvn clean test -PcloudIosWeb - initializes web application test on device iPhone X  

Note, that before running native tests drag&drop apk file from src/main/resources/ to 

!Attention

To run the tests on EPAM Mobile Cloud person should provide his personal token for security reasons. It can be found in users settings on mobilecloud.epam.com. Copy the token
and paste it in file src/test/resources/project.properties. 
