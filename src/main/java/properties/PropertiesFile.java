package properties;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesFile {
    private static final Properties properties = new Properties();
    private static final File file = new File("src/test/resources/project.properties");

    public PropertiesFile() {
        try {
            InputStream input = new FileInputStream(file);
            properties.load(input);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getProjectName() {
        return properties.getProperty("projectName");
    }

    public String getToken() {
        return properties.getProperty("token");
    }

    public String getAppiumHub() {
        return properties.getProperty("appiumHub");
    }
}
