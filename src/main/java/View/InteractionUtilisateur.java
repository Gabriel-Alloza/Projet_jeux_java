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

        if(cells[x][y].getRepresentation().equals("   ")){
            cells[x][y].setRepresentation(player.getRepresentation());
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

    public String inputsymbol(){
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
