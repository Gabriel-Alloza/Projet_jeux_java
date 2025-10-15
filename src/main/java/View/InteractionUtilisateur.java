package View;

import Model.Cell;
import Model.Player;

import java.util.Scanner;

public class InteractionUtilisateur {
    public InteractionUtilisateur(){

    }

    public boolean getMove(int size, Cell[][] cells, Player player){
        View view = new View();
        Scanner sc = new Scanner(System.in);

        view.coordY();
        if(!sc.hasNextInt()){
            view.nbEntier();
            sc.next();
            return true;
        }

        int X = sc.nextInt();
        if(X>=size || X<0){
            view.mauvaiseEntree();
            return true;
        }

        view.coordX();

        if(!sc.hasNextInt()){
            view.nbEntier();
            sc.next();
            return true;
        }
        int Y = sc.nextInt();
        if(Y>=size || Y<0){
            view.mauvaiseEntree();
            return true;
        }

        if(cells[X][Y].getRepresentation().equals("   ")){
            cells[X][Y].setRepresentation(player.getRepresentation());
        }
        else{
            view.caseOccupe();
            return true;
        }


        return false;
    }

    public String play(){
        View view = new View();
        Scanner sc = new Scanner(System.in);
        view.PvpPve();

        String choice = sc.nextLine();

        return choice;
    }

    public String Inputsymbol(){
        Scanner sc = new Scanner(System.in);
        String symbol = sc.nextLine();
        return " " + symbol + " ";
    }

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
