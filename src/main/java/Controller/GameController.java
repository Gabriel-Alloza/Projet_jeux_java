package Controller;
import Model.Cell;
import View.View;
import View.InteractionUtilisateur;
import Model.Player;


public class GameController {
    public GameController(){

    }

    /**
     *
     * @param longueur
     * @param cells
     * @param largeur
     *
     * Affiche le tableau
     */
    public void displayBoard(int longueur, Cell[][] cells, int largeur){
        View view = new View();
        view.displayBoard(longueur, cells, largeur);
    }

    /**
     *
     * @param taille
     * @param cells
     * @param player
     * @return
     *
     * Prend le choix du joueur
     */
    public boolean getMove(int taille, Cell[][] cells, Player player){
        InteractionUtilisateur interaction = new InteractionUtilisateur();
        return interaction.getMove(taille, cells, player);
    }

    /**
     * fait tourner le jeu (pour le tictactoe)
     * @return
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
     * @return
     */

    public int inputInteger(){
        InteractionUtilisateur interaction = new InteractionUtilisateur();
        return interaction.inputInteger();
    }

}

