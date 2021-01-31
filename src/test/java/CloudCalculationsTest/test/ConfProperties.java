package CloudCalculationsTest.test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfProperties {
    /*
    Reader to get some properties from external place.
    Can be useful if the same properties are placed in the different places of the project
     (to change initial settings instead of searching the code for all of them).
    */
    protected static FileInputStream fileInputStream;
    protected static Properties PROPERTIES;
    static {
        try{
            fileInputStream = new FileInputStream("src/test/java/CloudCalculationsTest/resources/conf.properties");
            PROPERTIES = new Properties();
            PROPERTIES.load(fileInputStream);}
            catch (IOException e) {
            e.printStackTrace();
            } finally {
            if (fileInputStream != null)

                    try {
                        fileInputStream.close();
                    } catch (IOException e) {
                        e.printStackTrace();}
                    }
        {
        }
    }public static String getProperty(String key) {
        return PROPERTIES.getProperty(key);
    }
}
