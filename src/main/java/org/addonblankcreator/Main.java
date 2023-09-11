package org.addonblankcreator;

import org.addonblankcreator.Objects.Addon;
import org.addonblankcreator.Utility.CopyFileFromResources;
import org.addonblankcreator.Utility.CopyFile;
import org.addonblankcreator.Utility.CreateFoldersFromFiles;
import org.addonblankcreator.Utility.FolderCreator;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Checking for permission to write to a folder.
        if (Files.isWritable(Path.of(System.getProperty("user.dir")))) {
            // has write access.
            System.out.println("Проверка наличия прав записи в папке " + Path.of(System.getProperty("user.dir")) +
                    "...[ok]");
        } else {
            // no write access.
            System.out.println("Проверка наличия прав записи в папке" + Path.of(System.getProperty("user.dir")) +
                    "...[ОШИБКА]");
            System.out.println("Для создания файлов требуются права на запись. Убедитесь, в наличии прав на запись" +
                    " и перезапустите программу.");
            System.exit(0);
        }

        // Addon data collection.
        Addon addon = new Addon(
                "",
                "Cart-Power: Blank addon name",
                "Cart-Power: Заготовка имени модуля",
                "Blank description of the addon.",
                "Заготовка описания модуля."
                );

        while (addon.id.isEmpty()) {
            System.out.println("Введите id модуля с префиксом \"cp_\" (например cp_addon_name):");
            Scanner console = new Scanner(System.in);
            if (console.hasNextLine()) {
                addon.id = console.nextLine().replaceAll("\\s+","");
            } else return;
            if (addon.id.isEmpty()) {
                System.out.println("Id модуля не введено. Введите id модуля.");
            } else {
                String actionConfirm = "";
                boolean valid = true;
                while (valid) {
                    System.out.println("Вы уверены, что хотите создать модуль с id \"" + addon.id + "\"? Y/N?");
                    if (console.hasNextLine()) {
                        actionConfirm = console.nextLine().toLowerCase();
                    } else return;
                    if (actionConfirm.equals("y")) {
                        valid = false;
                    } else  if (actionConfirm.equals("n")) {
                        valid = false;
                        addon.id = "";
                    } else {
                        System.out.println("Пожалуйста, введите Y или N.");
                    }
                }
            }
        }
        System.out.println("Id модуля задано: \"" + addon.id + "\"...[ok]");
        System.out.println("Создание модуля \"" + addon.id + "\"...");

//        File appAddons = new File(addon.id + "/app/addons/" + addon.id);
//        File designBackendMediaImagesAddons = new File(addon.id + "/design/backend/media/images/addons/" + addon.id);
//        String iconInputPath = "static/icon.png";
//        String iconOutputPath = designBackendMediaImagesAddons + "\\icon.png";
//        File varLangsEnAddons = new File(addon.id + "/var/langs/en/addons/");
//        File varLangsRuAddons = new File(addon.id + "/var/langs/ru/addons/");

        // Writing addon directories.
        System.out.println("Создание структуры каталога...");
        Addon.createAddonStructure(addon);
        FolderCreator folderCreator = new CreateFoldersFromFiles();
        folderCreator.createFolders(Addon.folderStructure);

        // Writing addon.xml file.
        try {
            BufferedWriter writer = new BufferedWriter(
                    new FileWriter(addon.id + "/app/addons/" + addon.id + "/addon.xml"));
            writer.write("<?xml version=\"1.0\"?>");
            writer.write("\n<addon scheme=\"3.0\">");
            writer.write("\n    <id>" + addon.id + "</id>");
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

        // Coping addon icon.
        Addon.iconOutputPath = Addon.folderStructure.get(1) + "\\icon.png";
        try {
            CopyFile copyFile = new CopyFileFromResources();
            copyFile.copy(Addon.iconInputPath,Addon.iconOutputPath);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        // Writing language variables files.
        try {
            BufferedWriter writer1 = new BufferedWriter(
                    new FileWriter(addon.id + "/var/langs/en/addons/" + addon.id + ".po"));
            BufferedWriter writer2 = new BufferedWriter(
                    new FileWriter(addon.id + "/var/langs/ru/addons/" + addon.id + ".po"));

            writer1.write("msgid \"\"");
            writer1.write("\nmsgstr \"Project-Id-Version: tygh\"");
            writer1.write("\n\"Content-Type: text/plain; charset=UTF-8\\n\"");
            writer1.write("\n\"Language-Team: English\\n\"");
            writer1.write("\n\"Language: en_US\\n\"");
            writer1.write("\n");
            writer1.write("\nmsgctxt \"Addons::name::" + addon.id+ "\"");
            writer1.write("\nmsgid \"" + addon.nameEn + "\"");
            writer1.write("\nmsgstr \"" + addon.nameEn + "\"");
            writer1.write("\n");
            writer1.write("\nmsgctxt \"Addons::description::" + addon.id + "\"");
            writer1.write("\nmsgid \"" + addon.descriptionEn + Addon.addonDescriptionEndingEn);
            writer1.write("\nmsgstr \"" + addon.descriptionEn + Addon.addonDescriptionEndingEn);
            writer1.close();
            System.out.println("Файл языковой переменной EN языка добавлен...[ok]");

            writer2.write("msgid \"\"");
            writer2.write("\nmsgstr \"Project-Id-Version: tygh\"");
            writer2.write("\n\"Content-Type: text/plain; charset=UTF-8\\n\"");
            writer2.write("\n\"Language-Team: Russian\\n\"");
            writer2.write("\n\"Language: ru_RU\\n\"");
            writer2.write("\n");
            writer2.write("\nmsgctxt \"Addons::name::" + addon.id+ "\"");
            writer2.write("\nmsgid \"" + addon.nameRu + "\"");
            writer2.write("\nmsgstr \"" + addon.nameRu + "\"");
            writer2.write("\n");
            writer2.write("\nmsgctxt \"Addons::description::" + addon.id + "\"");
            writer2.write("\nmsgid \"" + addon.descriptionEn + Addon.addonDescriptionEndingEn);
            writer2.write("\nmsgstr \"" + addon.descriptionRu + Addon.addonDescriptionEndingRu);
            writer2.close();
            System.out.println("Файл языковой переменной RU языка добавлен...[ok]");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Создание модуля завершено.");
    }
}