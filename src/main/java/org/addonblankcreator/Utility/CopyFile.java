package org.addonblankcreator.Utility;

import java.io.FileNotFoundException;

/**
 * Interface that copies files.
 */
public interface CopyFile {
    /**
     * Method that should use to copy files.
     *
     * @param fileInputPath - path to the source file to be copied.
     * @param fileOutputPath - path where the file should be copied.
     * @throws FileNotFoundException - an exception that can be thrown if the source file was not found.
     */
    void copy(String fileInputPath, String fileOutputPath) throws FileNotFoundException;
}