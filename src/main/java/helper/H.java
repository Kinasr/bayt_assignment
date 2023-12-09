package helper;

import utility.exception.ShotFileException;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class H {
    private H() {
    }

    public static String timestamp() {
        return ZonedDateTime.now()
                .format(DateTimeFormatter.ofPattern("yyyMMddHHmmssSSS"));
    }

    public static void saveByteArray(byte[] bytes, String path, String fileName) {
        try (FileOutputStream screenshotOutputStream = new FileOutputStream(path + fileName)) {
            screenshotOutputStream.write(bytes);
        } catch (IOException e) {
            if (!isDirectoryExist(path)) {
                createDirectory(path);
                saveByteArray(bytes, path, fileName);
            } else
                throw new ShotFileException("Can not save this screenshot <" + path + fileName + ">", e);
        }
    }

    /**
     * Check if a directory exists at the given path.
     *
     * @param path the path to the directory
     * @return true if the directory exists, false otherwise
     */
    public static boolean isDirectoryExist(String path) {
        var file = new File(path);
        return file.exists() && file.isDirectory();
    }

    /**
     * Creates a directory at the specified path.
     *
     * @param path the path where the directory will be created
     */
    public static void createDirectory(String path) {
        try {
            Files.createDirectories(Paths.get(path));
        } catch (IOException e) {
            throw new ShotFileException("Can not create directory <" + path + ">", e);
        }
    }

    public static String capitalizeFirstLetter(String str) {
        return str.substring(0, 1).toUpperCase() +
                str.substring(1).toLowerCase();
    }
}
