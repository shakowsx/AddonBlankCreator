package org.addonblankcreator.Utility;

import org.addonblankcreator.Objects.Addon;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class WritingFileFromCode implements Writer {
    public void writeAddonXML(Addon addon) {
        try {
            BufferedWriter writer = new BufferedWriter(
                    new FileWriter(addon.getId() + "/app/addons/" + addon.getId() + "/addon.xml"));
            writer.write("<?xml version=\"1.0\"?>");
            writer.write("\n<addon scheme=\"3.0\">");
            writer.write("\n    <id>" + addon.getId() + "</id>");
            writer.write("\n    <version>1.0</version>");
            writer.write("\n    <priority>5000</priority>");
            writer.write("\n    <position>100</position>");
            writer.write("\n    <status>disabled</status>");
            writer.write("\n    <default_language>en</default_language>");
            writer.write("\n    <has_icon>Y</has_icon>");
            writer.write("\n    <authors>");
            writer.write("\n        <author>");
            writer.write("\n            <name>Cart-Power</name>");
            writer.write("\n            <email>sales@cart-power.com</email>");
            writer.write("\n            <url>https://cart-power.com</url>");
            writer.write("\n        </author>");
            writer.write("\n    </authors>");
            writer.write("\n    <supplier>Cart-Power</supplier>");
            writer.write("\n    <supplier_link>https://cart-power.com</supplier_link>");
            writer.write("\n</addon>");
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void writeLangVars(Addon addon) {
        try {
            BufferedWriter writer1 = new BufferedWriter(
                    new FileWriter(addon.getId() + "/var/langs/en/addons/" + addon.getId() + ".po"));
            BufferedWriter writer2 = new BufferedWriter(
                    new FileWriter(addon.getId() + "/var/langs/ru/addons/" + addon.getId() + ".po"));

            writer1.write("msgid \"\"");
            writer1.write("\nmsgstr \"Project-Id-Version: tygh\"");
            writer1.write("\n\"Content-Type: text/plain; charset=UTF-8\\n\"");
            writer1.write("\n\"Language-Team: English\\n\"");
            writer1.write("\n\"Language: en_US\\n\"");
            writer1.write("\n");
            writer1.write("\nmsgctxt \"Addons::name::" + addon.getId()+ "\"");
            writer1.write("\nmsgid \"" + addon.getNameEn() + "\"");
            writer1.write("\nmsgstr \"" + addon.getNameEn() + "\"");
            writer1.write("\n");
            writer1.write("\nmsgctxt \"Addons::description::" + addon.getId() + "\"");
            writer1.write("\nmsgid \"" + addon.getDescriptionEn() + Addon.DESCRIPTION_ENDING_EN);
            writer1.write("\nmsgstr \"" + addon.getDescriptionEn() + Addon.DESCRIPTION_ENDING_EN);
            writer1.close();
            System.out.println("Файл языковой переменной EN языка добавлен...[ok]");

            writer2.write("msgid \"\"");
            writer2.write("\nmsgstr \"Project-Id-Version: tygh\"");
            writer2.write("\n\"Content-Type: text/plain; charset=UTF-8\\n\"");
            writer2.write("\n\"Language-Team: Russian\\n\"");
            writer2.write("\n\"Language: ru_RU\\n\"");
            writer2.write("\n");
            writer2.write("\nmsgctxt \"Addons::name::" + addon.getId()+ "\"");
            writer2.write("\nmsgid \"" + addon.getNameRu() + "\"");
            writer2.write("\nmsgstr \"" + addon.getNameRu() + "\"");
            writer2.write("\n");
            writer2.write("\nmsgctxt \"Addons::description::" + addon.getId() + "\"");
            writer2.write("\nmsgid \"" + addon.getDescriptionEn() + Addon.DESCRIPTION_ENDING_EN);
            writer2.write("\nmsgstr \"" + addon.getDescriptionRu() + Addon.DESCRIPTION_ENDING_RU);
            writer2.close();
            System.out.println("Файл языковой переменной RU языка добавлен...[ok]");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
