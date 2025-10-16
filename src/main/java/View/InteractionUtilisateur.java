package View;

import Model.Cell;
import Model.Player;

import java.util.Scanner;

public class InteractionUtilisateur {
    public InteractionUtilisateur(){

    }

    /**
     *
     * @param size
     * @param cells
     * @param player
     * @return
     */
    //Prend la case ou l'utilisasteur joue, renvoie un booléen pour indiquer si la case est libre ou non, et remplie la case. Utilisé uniquement avec tictactoe.
    public boolean getMove(int size, Cell[][] cells, Player player){
        View view = new View();
        Scanner sc = new Scanner(System.in);

        //prend les coodonées x et y et affiche un message d'erreur si elles sont mauvaises
        view.coordY();
        if(!sc.hasNextInt()){
            view.nbEntier();
            sc.next();
            return true;
        }

        int x = sc.nextInt();
        if(x>=size || x<0){
            view.mauvaiseEntree();
            return true;
        }

        view.coordX();

        if(!sc.hasNextInt()){
            view.nbEntier();
            sc.next();
            return true;
        }
        int y = sc.nextInt();
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

    //Demande à l'utilisateur si il veut joueur en PVP ou PVE et renvoie la réponse.
    public String play(){
        View view = new View();
        Scanner sc = new Scanner(System.in);
        view.PvpPve();

        String choice = sc.nextLine();

        return choice;
    }

    //Demande à l'tilisateur le symbol qu'il veut utiliser pour la partie et le renvoie.
    public String inputsymbol(){
        Scanner sc = new Scanner(System.in);
        String symbol = sc.nextLine();
        return " " + symbol + " ";
    }

    //Demande à l'utilisateur de saisir un nombre entier, et teste s'il ne le fait pas.
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
