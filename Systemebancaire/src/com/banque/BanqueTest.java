package com.banque;

public class BanqueTest {
    public static void main(String[] args) {
        
        Banque banque = new Banque(10); 

        
        CompteBancaire compte1 = new CompteBancaire("001", "was");
        CompteBancaire compte2 = new CompteBancaire("002", "ler");
        CompteCourant compteCourant1 = new CompteCourant("003", "sim", 200); 
        CompteEpargne compteEpargne1 = new CompteEpargne("004", "yo", 5); 


        
        banque.ajouterCompte(compte1);
        banque.ajouterCompte(compte2);
        banque.ajouterCompte(compteCourant1);
        banque.ajouterCompte(compteEpargne1);

        
       

        
        compte1.deposer(1500);
        compteCourant1.deposer(800);
        

        
        compte1.retirer(200); 
        compteCourant1.retirer(900); 
        
        compteEpargne1.deposer(1000); 
        compteEpargne1.calculerInteret();

        
        banque.transfert("001", "002", 300); 
        banque.transfert("003", "001", 100); 

        compteEpargne1.deposer(1000);
        compteEpargne1.calculerInteret();
        
        System.out.println("\nSoldes après les transactions :");
        compte1.afficherSolde(); 
        compte2.afficherSolde(); 
        compteCourant1.afficherSolde(); 
        compteEpargne1.afficherSolde();
        
        
        
        compte1.afficherHistoriqueTransactions();
        compteCourant1.afficherHistoriqueTransactions();
        compteEpargne1.afficherHistoriqueTransactions();
        
        Banque.afficherNombreComptes();
    }
}

