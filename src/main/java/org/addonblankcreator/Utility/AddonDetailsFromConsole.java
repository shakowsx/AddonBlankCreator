package org.addonblankcreator.Utility;

import org.addonblankcreator.Objects.Addon;

import java.util.Scanner;

public class AddonDetailsFromConsole implements AddonDetails {
    public void setAddonId(Addon addon) {
        while (addon.getId().isEmpty()) {
            System.out.println("Введите id модуля с префиксом \"cp_\" (например cp_addon_name):");
            Scanner console = new Scanner(System.in);

            if (console.hasNextLine()) {
                addon.setId(console.nextLine().replaceAll("\\s+",""));
            } else return;

            if (addon.getId().isEmpty()) {
                System.out.println("Id модуля не введено. Введите id модуля.");
            } else {
                String actionConfirm = "";
                boolean valid = true;

                while (valid) {
                    System.out.println("Вы уверены, что хотите создать модуль с id \"" + addon.getId() + "\"? Y/N?");

                    if (console.hasNextLine()) {
                        actionConfirm = console.nextLine().toLowerCase();
                    } else return;

                    if (actionConfirm.equals("y")) {
                        valid = false;
                    } else if (actionConfirm.equals("n")) {
                        valid = false;
                        addon.setId("");
                    } else {
                        System.out.println("Пожалуйста, введите Y или N.");
                    }
                }
            }
        }
        System.out.println("Id модуля задано: \"" + addon.getId() + "\"...[ok]");
    }
}
