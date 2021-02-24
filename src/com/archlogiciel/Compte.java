package com.archlogiciel;

public abstract class Compte {
    private Integer code;
    private Integer codeClient;
    private Double solde;

    public Compte(Integer code, Integer codeClient, Double solde) {
        this.code = code;
        this.codeClient = codeClient;
        this.solde = solde;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public Integer getCodeClient() {
        return codeClient;
    }

    public void setCodeClient(Integer codeClient) {
        this.codeClient = codeClient;
    }

    public Double getSolde() {
        return solde;
    }

    public void setSolde(Double solde) throws Exception {
        this.solde = solde;
    }

    @Override
    public String toString() {
        return String.format("""
                Code Compte: %d
                Code Client: %d
                Solde: %.1f""", code, codeClient, solde);
    }
}
