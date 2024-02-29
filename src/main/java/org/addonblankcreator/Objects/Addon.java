package org.addonblankcreator.Objects;

import java.io.File;
import java.util.*;

/**
 * An object representing information about a module (addon), expanding the functionality of the main core
 * of the CS-Cart platform or other modules.
 *
 * @see Addon
 */
public class Addon {
    /**
     * Addon ID.
     */
    private String id;

    /**
     * Addon name in English.
     */
    private String nameEn;

    /**
     * Addon name in Russian.
     */
    private String nameRu;

    /**
     * Description of the addon in English.
     */
    private String descriptionEn;

    /**
     * Description of the addon in Russian.
     */
    private String descriptionRu;

    /**
     * An ending added to the addon description in English.
     */
    public static final String DESCRIPTION_ENDING_EN =
            "Developed by <a target=\\\"_blank\\\" href=\\\"https://cart-power.com/\\\">Cart-Power</a>";

    /**
     * An ending added to the addon description in Russian.
     */
    public static final String DESCRIPTION_ENDING_RU =
            "Разработано <a target=\\\"_blank\\\" href=\\\"https://cart-power.ru/\\\">Cart-Power</a>";

    /**
     * Addon file folder structure.
     * In which the folder name is used as a {@code string}, and the path to the folder is used as a {@code file}.
     */
    public static final HashMap<String, File> FOLDER_STRUCTURE = new HashMap<>();

    /**
     * Addon icon file name.
     */
    public static final String ICON_FILE_NAME = "icon.png";

    /**
     * Path to the addon icon source file.
     */
    public static final String ICON_INPUT_PATH = "static/" + ICON_FILE_NAME;

    /**
     * Path to which the addon icon file should be copied.
     */
    private static String iconOutputPath;

    /**
     * Constructs a new Addon object.
     *
     * @param id the unique identifier of the addon.
     * @param nameEn the name of the addon in English.
     * @param nameRu the name of the addon in Russian.
     * @param descriptionEn the description of the addon in English.
     * @param descriptionRu the description of the addon in Russian.
     */
    public Addon(String id, String nameEn, String nameRu, String descriptionEn, String descriptionRu) {
        this.id = id;
        this.nameEn = nameEn;
        this.nameRu = nameRu;
        this.descriptionEn = descriptionEn;
        this.descriptionRu = descriptionRu;
    }

    /**
     * Gets the unique identifier of the addon.
     *
     * @return the unique identifier of the addon.
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the unique identifier of the addon.
     *
     * @param id the unique identifier of the addon.
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Gets the name of the addon in English.
     *
     * @return the name of the addon in English/
     */
    public String getNameEn() {
        return nameEn;
    }

    /**
     * Sets the name of the addon in English.
     *
     * @param nameEn the name of the addon in English.
     */
    public void setNameEn(String nameEn) {
        this.nameEn = nameEn;
    }

    /**
     * Gets the name of the addon in Russian.
     *
     * @return the name of the addon in Russian.
     */
    public String getNameRu() {
        return nameRu;
    }

    /**
     * Sets the name of the addon in Russian.
     *
     * @param nameRu the name of the addon in Russian.
     */
    public void setNameRu(String nameRu) {
        this.nameRu = nameRu;
    }

    /**
     * Gets the description of the addon in English.
     *
     * @return the description of the addon in English.
     */
    public String getDescriptionEn() {
        return descriptionEn;
    }

    /**
     * Sets the description of the addon in English.
     *
     * @param descriptionEn the description of the addon in English.
     */
    public void setDescriptionEn(String descriptionEn) {
        this.descriptionEn = descriptionEn;
    }

    /**
     * Gets the description of the addon in Russian.
     *
     * @return the description of the addon in Russian.
     */
    public String getDescriptionRu() {
        return descriptionRu;
    }

    /**
     * Sets the description of the addon in Russian.
     *
     * @param descriptionRu the description of the addon in Russian.
     */
    public void setDescriptionRu(String descriptionRu) {
        this.descriptionRu = descriptionRu;
    }

    /**
     * Gets the output path of the icon of the addon.
     *
     * @return the output path of the icon of the addon.
     */
    public static String getIconOutputPath() {
        return iconOutputPath;
    }

    /**
     * Sets the output path of the icon of the addon.
     *
     * @param iconOutputPath the output path of the icon of the addon.
     */
    public static void setIconOutputPath(String iconOutputPath) {
        Addon.iconOutputPath = iconOutputPath;
    }

    /**
     * Method for creating an addon folder structure based on the addon id data and adding to the addon object
     * the path to the file into which the addon icon will be copied.
     *
     * @param addon addon for which you need to create a folder structure.
     */
    public static void createAddonStructure(Addon addon) {
        FOLDER_STRUCTURE.put("appAddons", new File(addon.id + "/app/addons/" + addon.id));
        FOLDER_STRUCTURE.put("designBackendMediaImagesAddons", new File(addon.id +
                "/design/backend/media/images/addons/" + addon.id));
        FOLDER_STRUCTURE.put("varLangsEnAddons", new File(addon.id + "/var/langs/en/addons/"));
        FOLDER_STRUCTURE.put("varLangsRuAddons", new File(addon.id + "/var/langs/ru/addons/"));

        // Setting constant using folder structure.
        setIconOutputPath(Addon.FOLDER_STRUCTURE.get("designBackendMediaImagesAddons") + "\\" +
                Addon.ICON_FILE_NAME);
    }
}