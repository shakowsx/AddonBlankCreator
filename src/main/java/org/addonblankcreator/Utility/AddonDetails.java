package org.addonblankcreator.Utility;

import org.addonblankcreator.Objects.Addon;

/**
 * Class that used for taking information about Addon from anywhere and setting this info to the Addon object.
 * It contains methods to set Addon fields.
 *
 * @see Addon
 */
public interface AddonDetails {
    /**
     * Method that should use for set Addon id.
     *
     * @param addon addon object.
     * @see Addon
     */
    void setAddonId(Addon addon);
}
