package org.addonblankcreator.Utility;

import org.addonblankcreator.Objects.Addon;

/**
 * Class that used for writing content in Addon files.
 * It contains methods to create this list of files:
 * <li>addon.xml</li>
 * <li>language variables files.</li>
 *
 * @see Addon
 */
public interface AddonWriter {
    /**
     * Method that should use for write addon.xml file
     *
     * @param addon addon object.
     *
     * @see Addon
     */
    void writeAddonXML(Addon addon);

    /**
     * Method that should use for write language variables files.
     *
     * @param addon addon object.
     *
     * @see Addon
     */
    void writeLangVars(Addon addon);
}