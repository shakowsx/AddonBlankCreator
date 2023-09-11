package org.addonblankcreator.Utility;

import java.io.FileNotFoundException;

public interface CopyFile {
    void copy(String fileInputPath, String fileOutputPath) throws FileNotFoundException;
}