package org.addonblankcreator.Utility;

import org.addonblankcreator.Objects.Addon;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class WritingFileFromCode implements AddonWriter {
    public void writeAddonXML(Addon addon) {
        try {
            BufferedWriter writer = new BufferedWriter(
                    new FileWriter(addon.getId() + "/app/addons/" + addon.getId() + "/addon.xml"));
            writer.write("""
                    <?xml version="1.0"?>
                    <addon scheme="3.0">
                        <id>${addonId}</id>
                        <version>1.0</version>
                        <priority>5000</priority>
                        <position>100</position>
                        <status>disabled</status>
                        <default_language>en</default_language>
                        <has_icon>Y</has_icon>
                        <authors>
                            <author>
                                <name>Cart-Power</name>
                                <email>sales@cart-power.com</email>
                                <url>https://cart-power.com</url>
                            </author>
                        </authors>
                        <supplier>Cart-Power</supplier>
                        <supplier_link>https://cart-power.com</supplier_link>
                    </addon>
                    """.replace("${addonId}",addon.getId()));
            writer.close();
            System.out.println("Файл addon.xml добавлен...[ok]");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void writeLangVars(Addon addon) {
        try {
            BufferedWriter writerEn = new BufferedWriter(
                    new FileWriter(addon.getId() + "/var/langs/en/addons/" + addon.getId() + ".po"));
            BufferedWriter writerRu = new BufferedWriter(
                    new FileWriter(addon.getId() + "/var/langs/ru/addons/" + addon.getId() + ".po"));

            writerEn.write("""
                    msgid ""
                    msgstr "Project-Id-Version: tygh"
                    "Content-Type: text/plain; charset=UTF-8"
                    "Language-Team: English"
                    "Language: en_US"
                                        
                    msgctxt "Addons::name::${addonId}"
                    msgid "${addonNameEn}"
                    msgstr "${addonNameEn}"
                                        
                    msgctxt "Addons::description::${addonId}"
                    msgid "${addonDescriptionEn} ${$addonDescriptionEndingEn}"
                    msgstr "${addonDescriptionEn} ${$addonDescriptionEndingEn}"
                    """
                    .replace("${addonId}",addon.getId())
                    .replace("${addonNameEn}",addon.getNameEn())
                    .replace("${addonDescriptionEn}",addon.getDescriptionEn())
                    .replace("${$addonDescriptionEndingEn}",Addon.DESCRIPTION_ENDING_EN));
            writerEn.close();
            System.out.println("Файл языковой переменной EN языка добавлен...[ok]");

            writerRu.write("""
                    msgid ""
                    msgstr "Project-Id-Version: tygh"
                    "Content-Type: text/plain; charset=UTF-8"
                    "Language-Team: Russian"
                    "Language: ru_RU"
                            
                    msgctxt "Addons::name::${addonId}"
                    msgid "${addonNameEn}"
                    msgstr "${addonNameRu}"
                                        
                    msgctxt "Addons::description::${addonId}"
                    msgid "${addonDescriptionEn} ${$addonDescriptionEndingEn}"
                    msgstr "${addonDescriptionRu} ${$addonDescriptionEndingRu}"
                    """
                    .replace("${addonId}", addon.getId())
                    .replace("${addonNameEn}", addon.getNameEn())
                    .replace("${addonNameRu}", addon.getNameRu())
                    .replace("${addonDescriptionEn}", addon.getDescriptionEn())
                    .replace("${$addonDescriptionEndingEn}", Addon.DESCRIPTION_ENDING_EN)
                    .replace("${addonDescriptionRu}", addon.getDescriptionRu())
                    .replace("${$addonDescriptionEndingRu}", Addon.DESCRIPTION_ENDING_RU));
            writerRu.close();
            System.out.println("Файл языковой переменной RU языка добавлен...[ok]");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
