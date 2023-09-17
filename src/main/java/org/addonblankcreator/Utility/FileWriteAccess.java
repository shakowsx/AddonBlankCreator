package org.addonblankcreator.Utility;

import java.nio.file.Files;
import java.nio.file.Path;

public class FileWriteAccess implements AccessChecker {
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
