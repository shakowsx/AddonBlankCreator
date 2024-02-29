package org.addonblankcreator.Utility;

import org.addonblankcreator.Objects.Addon;

/**
 * Interface that used for taking information about Addon from anywhere and setting this info to the Addon object.
 * It contains methods to set Addon fields.
 *
 * @see Addon
 */
public interface AddonDetails {
    /**
     * Method for setting Addon id. This method should be used to set Addon id.
     *
     * @param addon addon for which id should be set.
     *
     * @see Addon
     */
    void setAddonId(Addon addon);
}