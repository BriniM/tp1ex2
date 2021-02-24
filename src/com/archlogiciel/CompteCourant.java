package com.archlogiciel;

public class CompteCourant extends Compte {
    public CompteCourant(Integer code, Integer codeClient, Double solde) {
        super(code, codeClient, solde);
    }

    private final Double SOLDE_MIN = -500d;

    @Override
    public void setSolde(Double solde) throws Exception {
        if (solde < SOLDE_MIN)
            throw new Exception(String.format("Le solde ne peut pas etre inferieur a %f TND", SOLDE_MIN));
        super.setSolde(solde);
    }

    @Override
    public String toString() {
        return String.format("""
                --- CompteCourant ---
                %s""", super.toString());
    }
}
