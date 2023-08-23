package org.addonblankcreator;

import org.addonblankcreator.Utility.Utility;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
public class Main {
    public static void main(String[] args) {
        String addonName =
                "cp_blank";
        String addonEnDescription =
                "Test description of the addon.";
        String addonRuDescription =
                "Test description of the addon.";
        String addonEnDescriptionEnding =
                " Developed by <a target=\\\"_blank\\\" href=\\\"https://cart-power.com/\\\">Cart-Power</a>\"";
        String addonRuDescriptionEnding =
                "Test description of the addon.";

        File appAddons =
                new File(addonName + "/app/addons/" + addonName);
        File designBackendMediaImagesAddons =
                new File(addonName + "/design/backend/media/images/addons/" + addonName);
        File iconInputPath =
                new File("src/main/resources/icon.png");
        File iconOutputPath =
                new File(designBackendMediaImagesAddons + "/icon.png");
        File varLangsEnAddons =
                new File(addonName + "/var/langs/en/addons/");
        File varLangsRuAddons =
                new File(addonName + "/var/langs/ru/addons/");

        appAddons.mkdirs();
        System.out.println("Папка " + appAddons + " создана успешно.");
        designBackendMediaImagesAddons.mkdirs();
        System.out.println("Папка " + designBackendMediaImagesAddons + " создана успешно.");
        varLangsEnAddons.mkdirs();
        System.out.println("Папка " + varLangsEnAddons + " создана успешно.");
        varLangsRuAddons.mkdirs();
        System.out.println("Папка " + varLangsRuAddons + " создана успешно.");

        try {
            BufferedWriter writer = new BufferedWriter(
                    new FileWriter(addonName + "/app/addons/" + addonName + "/addon.xml"));
            writer.write("<?xml version=\"1.0\"?>");
            writer.write("\n<addon scheme=\"3.0\">");
            writer.write("\n    <id>" + addonName + "</id>");
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

        try {
            Utility.copyFile(iconInputPath, iconOutputPath);
            System.out.println("Файл иконки модуля добавлен успешно.");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try {
            BufferedWriter writer1 = new BufferedWriter(
                    new FileWriter(addonName + "/var/langs/en/addons/" + addonName + ".po"));
            BufferedWriter writer2 = new BufferedWriter(
                    new FileWriter(addonName + "/var/langs/ru/addons/" + addonName + ".po"));
            writer1.write("msgid \"\"");
            writer1.write("\nmsgstr \"Project-Id-Version: tygh\"");
            writer1.write("\n\"Content-Type: text/plain; charset=UTF-8\\n\"");
            writer1.write("\n\"Language-Team: English\\n\"");
            writer1.write("\n\"Language: en_US\\n\"");
            writer1.write("\n");
            writer1.write("\nmsgctxt \"Addons::name::" + addonName+ "\"");
            writer1.write("\nmsgid \"Cart-Power: Debug switcher [DEV HELPER]\"");
            writer1.write("\nmsgstr \"Cart-Power: Debug switcher [DEV HELPER]\"");
            writer1.write("\n");
            writer1.write("\nmsgctxt \"Addons::description::" + addonName + "\"");
            writer1.write("\nmsgid \"" + addonEnDescription + addonEnDescriptionEnding);
            writer1.write("\nmsgstr \"" + addonEnDescription + addonEnDescriptionEnding);

            writer1.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}