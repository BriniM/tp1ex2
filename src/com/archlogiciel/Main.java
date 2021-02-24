package com.archlogiciel;

public class Main {
    static Banque b = new Banque();

    public static void main(String[] args) {
        Menu.ajouterCommande("ajouter", Main::initialiserCompte); // Create
        Menu.ajouterCommande("consulter", () -> System.out.println(b));// Read
        Menu.ajouterCommande("comptes courant debiteurs", () -> System.out.println(b.comptesDebiteurs()));
        Menu.ajouterCommande("modifier", Main::modifierCompte); // Update
        Menu.ajouterCommande("supprimer", Main::supprimerCompte); // Delete

        Menu.loopAsync();
    }

    private static void initialiserCompte() {
        try {
            String typeCompte = Menu.question("type compte", "Epargne|Courant", "Epargne|Courant");
            if (typeCompte.equalsIgnoreCase("courant") || typeCompte.equalsIgnoreCase("epargne")) {
                int codeCompte = Integer.parseInt(Menu.question("code compte", Menu.integersregexp));
                int codeClient = Integer.parseInt(Menu.question("code client", Menu.integersregexp));
                double solde = Double.parseDouble(Menu.question("solde", Menu.decimalregexp));

                verifierOperation(b.ajouterCompte(codeCompte, codeClient, solde, typeCompte));
            }
        } catch (Exception e) { System.out.println(e.getMessage()); }
    }

    private static void modifierCompte() {
        try {
            int codeClient = Integer.parseInt(Menu.question("code client", Menu.integersregexp));
            Compte compteClient = b.getCompte(codeClient);

            if (compteClient != null) {
                var newSolde = Double.parseDouble(Menu.question("nouveau solde", Menu.decimalregexp));
                compteClient.setSolde(newSolde);
            } else
                System.out.println("Compte introuvable");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static void supprimerCompte() {
        try {
            int codeClient = Integer.parseInt(Menu.question("code client", Menu.integersregexp));
            verifierOperation(b.supprimerCompte(codeClient));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static void verifierOperation(boolean operation) {
        if (operation) {
            System.out.println("Succes");
        } else {
            System.out.println("Echec");
        }
    }
}
