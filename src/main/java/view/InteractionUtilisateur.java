package view;

import model.Cell;
import model.Player;

import java.util.Scanner;

public class InteractionUtilisateur {
    public InteractionUtilisateur(){

    }

    /**
     *
     *Prend la case ou l'utilisasteur joue, renvoie un booléen pour indiquer si la case est libre ou non, et remplie la case.
     *Utilisé uniquement avec tictactoe.
     *
     * @param size la taille de la grille
     * @param cells le tableau de cellules du jeu
     * @param player le joueur qui effectue le coup
     * @return true si la case est invalide ou occupée, false sinon
     *

     */
    public boolean getMove(int size, Cell[][] cells, Player player){
        View view = new View();
        Scanner scanner = new Scanner(System.in);

        //prend les coodonées x et y et affiche un message d'erreur si elles sont mauvaises
        view.coordY();
        if(!scanner.hasNextInt()){
            view.nbEntier();
            scanner.next();
            return true;
        }

        int x = scanner.nextInt();
        if(x>=size || x<0){
            view.mauvaiseEntree();
            return true;
        }

        view.coordX();

        if(!scanner.hasNextInt()){
            view.nbEntier();
            scanner.next();
            return true;
        }
        int y = scanner.nextInt();
        if(y>=size || y<0){
            view.mauvaiseEntree();
            return true;
        }

        //change le contenu d la cellule

        if(cells[x][y].getRepresentation().equals("   ")){
            cells[x][y].setRepresentation(player.getRepresentation());
        }
        else{ //Teste si la case est déjà occupée
            view.caseOccupe();
            return true;
        }


        return false;
    }

    /**
     * Demande à l'utilisateur si il veut joueur en PVP ou PVE et renvoie la réponse.
     * @return Le choix du joueur (PVP, PVE ou EVE)
     */
    public String play(){
        View view = new View();
        Scanner sc = new Scanner(System.in);
        view.PvpPve();

        String choice = sc.nextLine();

        return choice;
    }

    /**
     * Demande à l'tilisateur le symbol qu'il veut utiliser pour la partie et le renvoie.
     * @return le symbole saisi par l'utilisateur avec un espace de chaque côté
     */
    public String inputSymbol(){
        Scanner sc = new Scanner(System.in);
        String symbol = sc.nextLine();
        return " " + symbol + " ";
    }


    /**
     * Demande à l'utilisateur de saisir un nombre entier, et teste s'il ne le fait pas.
     * @return un nombre entier saisi par l'utilisteur.
     */
    public int inputInteger(){
        Scanner sc = new Scanner(System.in);
        if(sc.hasNextInt()){
            return sc.nextInt();
        }
        else {
            return 42;
        }
    }


}
