package hduappium;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baseclass3 {
    private static Process appiumProcess;

    public static void startAppiumServer() {
        String nodePath = "C:\\Program Files\\nodejs\\node.exe"; // Path to Node.js executable on Windows
        String appiumPath = "C:\\Users\\hdu\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"; // Path to Appium's main.js file on Windows
        String command = nodePath + " " + appiumPath;

        try {
            appiumProcess = Runtime.getRuntime().exec(command);

            // Read and print Appium server output
            BufferedReader reader = new BufferedReader(new InputStreamReader(appiumProcess.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

            // Wait for the Appium server to start (you can adjust the waiting mechanism)
            Thread.sleep(5000); // Wait for 5 seconds (adjust as needed)
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void stopAppiumServer() {
        if (appiumProcess != null) {
            appiumProcess.destroy();
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
