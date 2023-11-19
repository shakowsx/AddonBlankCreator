package org.addonblankcreator.Utility;

import org.addonblankcreator.Objects.Addon;

import java.util.Scanner;

/**
 * This class takes information about Addon from users through console (terminal).
 * Method asks user to type some information about Addon. Uses Scanner for parsing types.
 *
 * @see Addon
 * @see Scanner
 */
public class AddonDetailsFromConsole implements AddonDetails {
    /**
     * Sets Addon id. It asks user to type Addon id in console (terminal) and sets this information to
     * the Addon object. Uses Scanner for parsing types.
     * <p>
     * - Deletes all empty spaces at the end of the user's input.
     * <p>
     * - If user's input is empty or nothing was inputted at all, then asks to type id again.
     * <p>
     * - Method has a validation process. It asks user to validate his input by typing Y or N letter. Where:
     * <li>Y - is Yes, input valid;</li>
     * <li>N - is No, input not valid.</li>
     *
     * @param addon addon object.
     * @see Addon
     * @see Scanner
     */
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
                boolean valid = false;

                while (!valid) {
                    System.out.println("Вы уверены, что хотите создать модуль с id \"" + addon.getId() + "\"? Y/N?");

                    if (console.hasNextLine()) {
                        actionConfirm = console.nextLine().toLowerCase();
                    } else return;

                    if (actionConfirm.equals("y")) {
                        valid = true;
                    } else if (actionConfirm.equals("n")) {
                        valid = true;
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
