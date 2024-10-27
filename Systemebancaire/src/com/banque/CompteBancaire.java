package com.banque;
import java.util.ArrayList;
import java.util.List;



public class CompteBancaire {
        private String numeroCompte;
        private double solde;
        private String titulaire;
        private List<Transaction> historiqueTransactions;

        
        
        
        public CompteBancaire(String numeroCompte , String titulaire) {
        	this.numeroCompte = numeroCompte;
            this.titulaire = titulaire;
            this.solde = 0.0;
            this.historiqueTransactions = new ArrayList<>();
        }
        
        
        public void deposer(double montant) {
        	if (montant > 0) {
                solde += montant;
                historiqueTransactions.add(new Transaction("crédit", montant));
                System.out.println("Dépôt de " + montant + " effectué.");
            } else {
                System.out.println("Le montant doit être positif.");
            }
        }
        public void retirer(double montant) {
        	        if (montant > 0 && montant <= solde) {
        	            solde -= montant;
        	            historiqueTransactions.add(new Transaction("débit", montant));
        	            System.out.println("Retrait de " + montant + " effectué.");
        	        } else {
        	            System.out.println("Retrait non autorisé. Solde insuffisant ou montant invalide.");
        	        }
        	    }	
        public void transfert(CompteBancaire compteDest, double montant) {
            if (montant > 0 && solde >= montant) {
                this.retirer(montant);
                compteDest.deposer(montant);
                historiqueTransactions.add(new Transaction("débit", montant));
                compteDest.historiqueTransactions.add(new Transaction("crédit", montant)); 
                System.out.println("Transfert de " + montant + " de " + this.numeroCompte + " à " + compteDest.numeroCompte + " effectué.");
            } else {
                System.out.println("Transfert non autorisé : solde insuffisant.");
            }
        }
        
        public void afficherHistoriqueTransactions() {
            System.out.println("Historique des transactions pour le compte " + numeroCompte + ":");
            for (Transaction transaction : historiqueTransactions) {
                System.out.println(transaction);
            }
        }
 
       public void afficherSolde() {
       System.out.println("Le solde actuel du compte est : " + solde);
       }
       public String getNumeroCompte() {
           return numeroCompte;
       }

       public double getSolde() {
           return solde;
       }
       
       public void setTitulaire(String titulaire) {
           this.titulaire = titulaire;
       }
        }
        

