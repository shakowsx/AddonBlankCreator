package org.addonblankcreator.Utility;

import java.nio.file.Files;
import java.nio.file.Path;

/**
 * This class checks files for write permissions.
 * Contains a method that performs certain actions after checking access.
 *
 * @see Files
 * @see FileWriteAccess#checkWriteAccess(Path)
 */
public class FileWriteAccess implements AccessChecker {
    /**
     * Checks whether you have permission to write at the specified path.
     * You can specify either a file or a folder in the path.
     * <p>
     * If there is no write permission, it initiates exit from the program.
     *
     * @param path path to folder or file.
     *
     * @see Path
     * @see Files
     */
    public void checkWriteAccess(Path path) {
        // Checking for write permissions.
        if (Files.isWritable(path)) {
            // has write access.
            System.out.println("Проверка наличия прав на запись " + path + "...[ok]");
        } else {
            // no write access.
            System.out.println("Недостаточно прав на запись " + path + "...[ОШИБКА]");
            System.out.println("Для создания и изменения файлов требуются права на запись. Убедитесь, в их наличии" +
                    " и перезапустите программу.");
            System.out.println("Программа завершена.");
            System.exit(0);
        }
    }
}