package org.addonblankcreator.Utility;

import org.addonblankcreator.Objects.Addon;

public interface AddonWriter {
    void writeAddonXML(Addon addon);

    void writeLangVars(Addon addon);
}