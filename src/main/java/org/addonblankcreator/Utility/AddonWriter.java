package org.addonblankcreator.Utility;

import org.addonblankcreator.Objects.Addon;

/**
 * Interface that used for writing content in Addon files.
 * It contains methods to create this list of files:
 * <ul>
 * <li>addon.xml</li>
 * <li>language variables files.</li>
 * </ul>
 *
 * @see Addon
 */
public interface AddonWriter {
    /**
     * Method that should use for write addon.xml file.
     *
     * @param addon addon for which you need to create an XML file.
     *
     * @see Addon
     */
    void writeAddonXML(Addon addon);

    /**
     * Method that should use for write language variables files.
     *
     * @param addon addon for which you need to create language variables.
     *
     * @see Addon
     */
    void writeLangVars(Addon addon);
}