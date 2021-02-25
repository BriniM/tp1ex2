package com.archlogiciel;

import java.util.ArrayList;

public class Banque {
    final private ArrayList<Compte> listeBanque = new ArrayList<>();

    public boolean ajouterCompte(Integer codeCompte, Integer codeClient, Double solde, String typeCompte) {
        switch(typeCompte) {
            case "courant":
                return listeBanque.add(new CompteCourant(codeCompte, codeClient, solde));
            case "epargne":
                try {
                    var tauxInteret = Float.parseFloat(Menu.question("taux interet", Menu.decimalregexp));
                    return listeBanque.add(new CompteEpargne(codeCompte, codeClient, solde, tauxInteret));
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            default:
                return false;
        }
    }

    @Override
    public String toString() {
        StringBuilder ret = new StringBuilder();
        for (var i : listeBanque)
            ret.append(i).append("\n");

        return ret.toString();
    }

    public String comptesDebiteurs() {
        StringBuilder ret = new StringBuilder();
        for (var i : listeBanque)
            if (i instanceof CompteCourant)
                if (i.getSolde() > 0)
                    ret.append(i).append("\n");

        return ret.toString();
    }

    public Compte getCompte(Integer codeClient) {
        for (var i : listeBanque)
            if (i.getCodeClient().equals(codeClient))
                return i;
        return null;
    }

    public boolean supprimerCompte(Integer codeClient) {
        for (var i : listeBanque)
            if (i.getCodeClient().equals(codeClient))
                return listeBanque.remove(i);
        return false;
    }
}
