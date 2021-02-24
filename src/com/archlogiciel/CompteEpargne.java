package com.archlogiciel;

public class CompteEpargne extends Compte {
    static private Float tauxInteret;
    private final Float INTERET_MIN = 0.2f;
    private final Float INTERET_MAX = 0.5f;

    public CompteEpargne(Integer code, Integer codeClient, Double solde, Float tauxInteret) throws Exception {
        super(code, codeClient, solde);
        if (tauxInteret >= INTERET_MIN && tauxInteret <= INTERET_MAX)
            CompteEpargne.tauxInteret = tauxInteret;
        else
            throw new Exception(String.format("Le taux d'interet doit etre compris entre %f et %f", INTERET_MIN,
                    INTERET_MAX));
    }

    public Float getTauxInteret() {
        return tauxInteret;
    }

    public void setTauxInteret(Float tauxInteret) {
        CompteEpargne.tauxInteret = tauxInteret;
    }

    @Override
    public String toString() {
        return String.format("""
                --- CompteEpargne ---
                %s
                Taux Interet: %.1f""", super.toString(), tauxInteret);
    }
}