package hduappium;

import java.io.File;

import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

import io.appium.java_client.service.local.flags.GeneralServerFlag;

public class Baseclass4 {
    private static AppiumDriverLocalService appiumService;

    public static void startAppiumServer() {
        AppiumServiceBuilder builder = new AppiumServiceBuilder();
        builder.usingDriverExecutable(new File("C:\\Program Files\\nodejs\\node.exe")) // Path to Node.js executable on Windows
                .withAppiumJS(new File("C:\\Users\\hdu\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js")) // Path to Appium's main.js file on Windows
                .withLogFile(new File("appium.log")) // Optional: Set log file path
                .withArgument(GeneralServerFlag.LOCAL_TIMEZONE) 
                .withArgument(GeneralServerFlag.LOG_LEVEL, "info"); // Optional: Set log level

        appiumService = AppiumDriverLocalService.buildService(builder);
        appiumService.start();
    }

    public static void stopAppiumServer() {
        if (appiumService != null) {
            appiumService.stop();
        }
    }

    public static void main(String[] args) {
        // Start the Appium server
        startAppiumServer();

        // Perform your Appium tests here

        // Stop the Appium server when done
        stopAppiumServer();
    }
}
