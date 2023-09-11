package org.addonblankcreator.Objects;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class Addon {
    public String id;
    public String nameEn;
    public String nameRu;
    public String descriptionEn;
    public String descriptionRu;
    public static final String addonDescriptionEndingEn =
            " Developed by <a target=\\\"_blank\\\" href=\\\"https://cart-power.com/\\\">Cart-Power</a>\"";
    public static final String addonDescriptionEndingRu =
            " Разработано <a target=\\\"_blank\\\" href=\\\"https://cart-power.ru/\\\">Cart-Power</a>";
    public static final List<File> folderStructure = new ArrayList<>();
    public static final String iconInputPath = "static/icon.png";
    public static String iconOutputPath;
//    public static final String iconOutputPath = folderStructure.get(1) + "\\icon.png";

    public Addon(String id, String nameEn, String nameRu, String descriptionEn, String getDescriptionRu) {
        this.id = id;
        this.nameEn = nameEn;
        this.nameRu = nameRu;
        this.descriptionEn = descriptionEn;
        this.descriptionRu = getDescriptionRu;
    }

    public static void createAddonStructure(Addon addon) {
        Collection<File> folders = new ArrayList<>();
        folders.add(new File(addon.id + "/app/addons/" + addon.id));
        folders.add(new File(addon.id + "/design/backend/media/images/addons/" + addon.id)); //iconOutputPath position.
        folders.add(new File(addon.id + "/var/langs/en/addons/"));
        folders.add(new File(addon.id + "/var/langs/ru/addons/"));
        folderStructure.addAll(folders);
    }
}
