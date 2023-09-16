package org.addonblankcreator.Objects;

import java.io.File;
import java.util.*;

public class Addon {
    private String id;
    private String nameEn;
    private String nameRu;
    private String descriptionEn;
    private String descriptionRu;
    public static final String DESCRIPTION_ENDING_EN =
            " Developed by <a target=\\\"_blank\\\" href=\\\"https://cart-power.com/\\\">Cart-Power</a>\"";
    public static final String DESCRIPTION_ENDING_RU =
            " Разработано <a target=\\\"_blank\\\" href=\\\"https://cart-power.ru/\\\">Cart-Power</a>";
//    public static final List<File> FOLDER_STRUCTURE = new ArrayList<>();
    public static final HashMap<String, File> FOLDER_STRUCTURE = new HashMap<>();
    public static final String ICON_FILE_NAME = "icon.png";

    public static final String ICON_INPUT_PATH = "static/" + ICON_FILE_NAME;
    private static String iconOutputPath;

    public Addon(String id, String nameEn, String nameRu, String descriptionEn, String getDescriptionRu) {
        this.id = id;
        this.nameEn = nameEn;
        this.nameRu = nameRu;
        this.descriptionEn = descriptionEn;
        this.descriptionRu = getDescriptionRu;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNameEn() {
        return nameEn;
    }

    public void setNameEn(String nameEn) {
        this.nameEn = nameEn;
    }

    public String getNameRu() {
        return nameRu;
    }

    public void setNameRu(String nameRu) {
        this.nameRu = nameRu;
    }

    public String getDescriptionEn() {
        return descriptionEn;
    }

    public void setDescriptionEn(String descriptionEn) {
        this.descriptionEn = descriptionEn;
    }

    public String getDescriptionRu() {
        return descriptionRu;
    }

    public void setDescriptionRu(String descriptionRu) {
        this.descriptionRu = descriptionRu;
    }

    public static String getIconOutputPath() {
        return iconOutputPath;
    }

    public static void setIconOutputPath(String iconOutputPath) {
        Addon.iconOutputPath = iconOutputPath;
    }

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
