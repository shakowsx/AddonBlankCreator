package org.addonblankcreator;

import org.addonblankcreator.Utility.Utility;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String addonId = "";

        while (addonId.isEmpty()) {
            System.out.println("Введите id модуля с префиксом \"cp_\" (например cp_addon_name):");
            Scanner console = new Scanner(System.in);
            addonId = console.nextLine().replaceAll("\\s+","");
            if (addonId.isEmpty()) {
                System.out.println("Id модуля не введено. Введите id модуля.");
            } else {
                String actionConfirm = "";
                boolean valid = true;
                while (valid) {
                    System.out.println("Вы уверены, что хотите создать модуль с id \"" + addonId + "\"? Y/N?");
                    actionConfirm = console.nextLine().toLowerCase();
                    if (actionConfirm.equals("y")) {
                        valid = false;
                    } else  if (actionConfirm.equals("n")) {
                        valid = false;
                        addonId = "";
                    } else {
                        System.out.println("Пожалуйста, введите Y или N.");
                    }
                }
            }
        }
        System.out.println("Id модуля задано: \"" + addonId + "\"");
        System.out.println("Создаю модуль \"" + addonId + "\"...");

        String addonNameEn =
                "Cart-Power: Blank addon name";
        String addonNameRu =
                "Cart-Power: Заготовка имени модуля";
        String addonDescriptionEn =
                "Blank description of the addon.";
        String addonDescriptionRu =
                "Заготовка описания модуля.";
        String addonDescriptionEndingEn =
                " Developed by <a target=\\\"_blank\\\" href=\\\"https://cart-power.com/\\\">Cart-Power</a>\"";
        String addonDescriptionEndingRu =
                " Разработано <a target=\\\"_blank\\\" href=\\\"https://cart-power.ru/\\\">Cart-Power</a>";

        File appAddons =
                new File(addonId + "/app/addons/" + addonId);
        File designBackendMediaImagesAddons =
                new File(addonId + "/design/backend/media/images/addons/" + addonId);
        File iconInputPath =
                new File("src/main/resources/icon.png");
        File iconOutputPath =
                new File(designBackendMediaImagesAddons + "/icon.png");
        File varLangsEnAddons =
                new File(addonId + "/var/langs/en/addons/");
        File varLangsRuAddons =
                new File(addonId + "/var/langs/ru/addons/");
        System.out.println("путь: " + Path.of("cp_test/"));
        if (Files.isWritable(Path.of(System.getProperty("user.dir")))) {
            System.out.println("Проверка наличия прав на создание папки прошла успешно.");
        } else {
            System.out.println("Ошибка! Нет прав на создание папки в " +
                    System.getProperty("user.dir") + " Программа завершена.");
            System.exit(0);
        }
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
                    new FileWriter(addonId + "/app/addons/" + addonId + "/addon.xml"));
            writer.write("<?xml version=\"1.0\"?>");
            writer.write("\n<addon scheme=\"3.0\">");
            writer.write("\n    <id>" + addonId + "</id>");
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
                    new FileWriter(addonId + "/var/langs/en/addons/" + addonId + ".po"));
            BufferedWriter writer2 = new BufferedWriter(
                    new FileWriter(addonId + "/var/langs/ru/addons/" + addonId + ".po"));

            writer1.write("msgid \"\"");
            writer1.write("\nmsgstr \"Project-Id-Version: tygh\"");
            writer1.write("\n\"Content-Type: text/plain; charset=UTF-8\\n\"");
            writer1.write("\n\"Language-Team: English\\n\"");
            writer1.write("\n\"Language: en_US\\n\"");
            writer1.write("\n");
            writer1.write("\nmsgctxt \"Addons::name::" + addonId+ "\"");
            writer1.write("\nmsgid \"" + addonNameEn + "\"");
            writer1.write("\nmsgstr \"" + addonNameEn + "\"");
            writer1.write("\n");
            writer1.write("\nmsgctxt \"Addons::description::" + addonId + "\"");
            writer1.write("\nmsgid \"" + addonDescriptionEn + addonDescriptionEndingEn);
            writer1.write("\nmsgstr \"" + addonDescriptionEn + addonDescriptionEndingEn);
            writer1.close();
            System.out.println("Файл языковой переменной EN языка добавлен успешно.");

            writer2.write("msgid \"\"");
            writer2.write("\nmsgstr \"Project-Id-Version: tygh\"");
            writer2.write("\n\"Content-Type: text/plain; charset=UTF-8\\n\"");
            writer2.write("\n\"Language-Team: Russian\\n\"");
            writer2.write("\n\"Language: ru_RU\\n\"");
            writer2.write("\n");
            writer2.write("\nmsgctxt \"Addons::name::" + addonId+ "\"");
            writer2.write("\nmsgid \"" + addonNameRu + "\"");
            writer2.write("\nmsgstr \"" + addonNameRu + "\"");
            writer2.write("\n");
            writer2.write("\nmsgctxt \"Addons::description::" + addonId + "\"");
            writer2.write("\nmsgid \"" + addonDescriptionEn + addonDescriptionEndingEn);
            writer2.write("\nmsgstr \"" + addonDescriptionRu + addonDescriptionEndingRu);
            writer2.close();
            System.out.println("Файл языковой переменной RU языка добавлен успешно.");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Создание модуля завершено успешно.");
    }
}