package org.addonblankcreator.Utility;

import java.nio.file.Path;

public interface AccessChecker {
    void checkWriteAccess(Path path);
}
