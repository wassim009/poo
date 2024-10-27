package com.banque;

public class Banque {
	private CompteBancaire[] comptes;
	private static int nombreComptes = 0;

public Banque(int taille) {
	this.comptes= new CompteBancaire [taille];
	
}

public void ajouterCompte (CompteBancaire compte) {
	if (nombreComptes < comptes.length) {
		comptes[nombreComptes]= compte;
		nombreComptes++;
		
		System.out.println("Compte ajoute: " + compte.getNumeroCompte());
	    
	}else {
		System.out.println ("Impossible d'ajouter le compte , tableau plein.");
		
	}

}
public CompteBancaire chercherCompte(String numeroCompte) {
    for (int i = 0; i < nombreComptes; i++) {
        if (comptes[i].getNumeroCompte().equals(numeroCompte)) {
            return comptes[i]; 
            }
    }
    return null; 
}

   public void transfert(String numeroSource, String numeroDest, double montant) {
    CompteBancaire compteSource = chercherCompte(numeroSource);
    CompteBancaire compteDest = chercherCompte(numeroDest);
    
    if (compteSource != null && compteDest != null) {
        if (montant > 0 && compteSource.getSolde() >= montant) {
            compteSource.retirer(montant);
            compteDest.deposer(montant);
            System.out.println("Transfert de " + montant + " de " + numeroSource + " à " + numeroDest + " effectué.");
        } else {
            System.out.println("Transfert impossible : solde insuffisant ou montant invalide.");
        }
    } else {
        System.out.println("Un ou plusieurs comptes non trouvés.");
    }
}
   
   
   public static void afficherNombreComptes() {
    System.out.println("Nombre total de comptes : " + nombreComptes);
}
}


