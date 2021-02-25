package com.archlogiciel;

import java.util.Scanner;
import java.util.HashMap;
import java.util.regex.Pattern;

final class Menu {
    final private static Scanner scanner = new Scanner(System.in);
    final private static HashMap<String, Runnable> commandes = new HashMap<>();

    // https://docs.oracle.com/javase/7/docs/api/java/util/regex/Pattern.html
    final static public String integersregexp = "^[0-9]+$";
    final static public String decimalregexp = "^[0-9]+(\\.[0-9])?$";

    public static String question(String cle, String regexp) throws Exception {
        System.out.printf("Donner %s: ", cle);
        var input = scanner.nextLine();

        Pattern pattern = Pattern.compile(regexp, Pattern.CASE_INSENSITIVE);
        if (pattern.matcher(input).find())
            return input;
        throw new Exception(String.format("Veuillez reformuler %s", cle));
    }

    public static String question(String cle, String description, String regexp) throws Exception {
        System.out.printf("Donner %s (%s): ", cle, description);
        var input = scanner.nextLine();

        Pattern pattern = Pattern.compile(regexp, Pattern.CASE_INSENSITIVE);
        if (pattern.matcher(input).find())
            return input;
        throw new Exception(String.format("Veuillez reformuler %s", cle));
    }

    public static void ajouterCommande(String commande, Runnable methode) {
        commandes.put(commande, methode);
    }

    public static void loop() {
        for(;;) {
            System.out.printf("Choisir commande %s: ", commandes.keySet());
            String input = scanner.nextLine();

            commandes.forEach((cmd, meth) -> {
                if (cmd.equalsIgnoreCase(input))
                    meth.run();
            });
        }
    }

    public static void loopAsync() {
        new Thread(Menu::loop).start();
    }
}
