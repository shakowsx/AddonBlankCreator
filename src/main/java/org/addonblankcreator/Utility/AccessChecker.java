package org.addonblankcreator.Utility;

import java.nio.file.Path;

/**
 * An abstract class that checks for any permissions and access.
 *
 */
public interface AccessChecker {
    /**
     * Checks for write permissions on a file or folder at the specified path
     * and performs actions depending on the result.
     *
     * @param path path to folder or file.
     *
     * @see Path
     */
    void checkWriteAccess(Path path);
}
