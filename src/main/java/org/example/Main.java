package org.example;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        String moduleName = "cp_blank";

        File appAddons = new File(moduleName + "/app/addons/" + moduleName);
        File varLangAddonsEn = new File(moduleName + "/var/lang/addons/" + moduleName + "/en/");
        File varLangAddonsRu = new File(moduleName + "/var/lang/addons/" + moduleName + "/ru");

        appAddons.mkdirs();
        System.out.println("Папка " + appAddons + " создана успешно.");
        varLangAddonsEn.mkdirs();
        System.out.println("Папка " + varLangAddonsEn + " создана успешно.");
        varLangAddonsRu.mkdirs();
        System.out.println("Папка " + varLangAddonsRu + " создана успешно.");

        try {
            BufferedWriter writer = new BufferedWriter(
                    new FileWriter(moduleName + "/app/addons/" + moduleName + "/addon.xml"));
            writer.write("<TEST></TEST>");
            writer.write("\n<TEST>" + moduleName + "</TEST>");
            writer.write("\n<TEST></TEST>");
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try {
            BufferedWriter writer1 = new BufferedWriter(
                    new FileWriter(moduleName + "/var/lang/addons/" + moduleName + "/en/" + moduleName + ".po"));
            BufferedWriter writer2 = new BufferedWriter(
                    new FileWriter(moduleName + "/var/lang/addons/" + moduleName + "/ru/" + moduleName + ".po"));
            writer1.write("<TEST></TEST>");
            writer1.write("\n<TEST>" + moduleName + "</TEST>");
            writer1.write("\n<TEST></TEST>");
            writer1.close();

            writer2.write("<TEST></TEST>");
            writer2.write("\n<TEST>" + moduleName + "</TEST>");
            writer2.write("\n<TEST></TEST>");
            writer2.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}