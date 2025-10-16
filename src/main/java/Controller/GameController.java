package Controller;
import Model.Cell;
import View.View;
import View.InteractionUtilisateur;
import Model.Player;


public class GameController {
    public GameController(){

    }

    public void displayBoard(int longueur, Cell[][] cells, int largeur){
        View view = new View();
        view.displayBoard(longueur, cells, largeur);
    }

    public boolean getMove(int taille, Cell[][] cells, Player player){
        InteractionUtilisateur interaction = new InteractionUtilisateur();
        return interaction.getMove(taille, cells, player);
    }

    public String play(){
        InteractionUtilisateur interaction = new InteractionUtilisateur();
        return interaction.play();
    }

    public void j1(){
        View view = new View();
        view.j1();
    }

    public void j2(){
        View view = new View();
        view.j2();
    }

    public void nextTurn(){
        View view = new View();
        view.nextTurn();
    }

    public void mauvaiseSaisie(){
        View view = new View();
        view.mauvaiseSaisie();
    }

}

