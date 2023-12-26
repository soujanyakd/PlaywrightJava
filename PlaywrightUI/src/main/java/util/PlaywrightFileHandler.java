package util;

import com.microsoft.playwright.Locator;

import java.nio.file.Path;
import java.nio.file.Paths;

public class PlaywrightFileHandler {

    public static void uploadFile(Locator locator, String path) {
        locator.setInputFiles(Paths.get(path));
    }

    public static void uploadMultipleFile(Locator locator, Path[] paths) {
        locator.setInputFiles(paths);
    }

    public static void removeAllTheUploadedFiles(Locator locator) {
        locator.setInputFiles(new Path[0]);
    }
}
