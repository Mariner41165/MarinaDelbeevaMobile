# MarinaDelbeevaMobile

###Run one of the following commands and see how tests pass on mobilecloud.epam.com:###  

mvn clean test -PcloudAndroid - initializes native application test on device Google Pixel 5  

mvn clean test -PcloudIos - initializes native application test on device iPhone 8 Plus

mvn clean test -PcloudWeb - initializes web application test on device Google Pixel 2  

mvn clean test -PcloudIosWeb - initializes native application test on device iPhone X  

####!Attention####

For security resasons you should provide presonal security token to run the tests on EPAM Mobile Cloud. You can get it on mobilecloud.epam.com in users settings. Copy the token
and paste it in file "project.properties" in the directory src/test/resources/. 
