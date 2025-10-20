package controller;
import model.Cell;
import view.View;
import view.InteractionUtilisateur;
import model.Player;


public class GameController {
    public GameController(){

    }

    /**
     *
     *Affiche le tableau
     * @param longueur longueur du tableau
     * @param cells le tableau de cellules du jeu
     * @param largeur largeur du tableau
     *
     */
    public void displayBoard(Integer longueur, Cell[][] cells, Integer largeur){
        if(longueur == null || longueur < 0){
            throw new IllegalArgumentException("La longueur du tableau doit être un entier positif.");
        }
        if(largeur == null || largeur < 0){
            throw new IllegalArgumentException("La largeur du tableau doit être un entier positif.");
        }

        if(cells == null){
            throw new IllegalArgumentException("Un tableau doit être entré en paramètres.");
        }

        View view = new View();
        view.displayBoard(longueur, cells, largeur);
    }

    /**
     * Prend le choix du joueur
     *
     * @param taille la taille de la grille
     * @param cells le tableau de jeu
     * @param player le joueur qui effectue le coup
     * @return true si la case est invalide ou occupée, false sinon
     *
     */
    public boolean getMove(int taille, Cell[][] cells, Player player){
        InteractionUtilisateur interaction = new InteractionUtilisateur();
        return interaction.getMove(taille, cells, player);
    }

    /**
     * fait tourner le jeu (pour le tictactoe)
     * @return Le choix du joueur (PVP, PVE ou EVE)
     */
    public String play(){
        InteractionUtilisateur interaction = new InteractionUtilisateur();
        return interaction.play();
    }

    /**
     * Affiche "joueur 1:"
     */
    public void j1(){
        View view = new View();
        view.j1();
    }


    /**
     * Affiche "joueur 2:"
     */
    public void j2(){
        View view = new View();
        view.j2();
    }

    /**
     * Affiche "tour suivant"
     */

    public void nextTurn(){
        View view = new View();
        view.nextTurn();
    }

    /**
     * Affiche "mauvaise saisie"
     */

    public void mauvaiseSaisie(){
        View view = new View();
        view.mauvaiseSaisie();
    }

    /**
     * Demande au joueur son choix pour le puissance 4
     */

    public void choixP4(){
        View view = new View();
        view.choixP4();
    }

    /**
     * Demande au joueur de rentrer un nombre entier.
     * @return Un nombre entier choisi par l'utilisateur
     */

    public int inputInteger(){
        InteractionUtilisateur interaction = new InteractionUtilisateur();
        return interaction.inputInteger();
    }

}

