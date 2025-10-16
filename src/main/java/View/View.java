package View;

import Model.Cell;

public class View {

    public  View(){

    }

    /**
     *
     * @param size
     * @param cells
     * @param longsize
     */

    //Affiche le tableau à partir de cells
    public void displayBoard(int size, Cell[][] cells, int longsize){
        //On initialise des str vides pour pouvoir y rajouter des caractères en boucle.
        String dispalyedCells = "";
        String separation = "";

        for (int i = 0; i<= longsize; i++){
            separation = separation+"----"; //Séparation entre les lignes
        }
        for (int i = 0; i<size; i++){
            System.out.println(separation);
            for (int j = 0; j< longsize; j++){
                dispalyedCells = dispalyedCells + "|" + cells[i][j].getRepresentation(); //Séparations entre les cases
            }
            dispalyedCells += "|";
            System.out.println(dispalyedCells);
            dispalyedCells = "";
        }
    }

    public void coordY(){
        System.out.println("Coordonée en Y:");
    }

    public void nbEntier(){
        System.out.println("Veuillez saisir un nombre entier!");
    }

    public void mauvaiseEntree(){
        System.out.println("Mauvaise entrée!");
    }

    public void coordX(){
        System.out.println("Coordonée en X:");
    }

    public void caseOccupe(){
        System.out.println("Case occupée!!");
    }

    public void PvpPve(){
        System.out.println("Préférez-vous jouer contre quelqu'un? (PVP), contre un bot? (PVE) ou voir deux bots l'un contre l'autre? (EVE)");
    }

    public void j1(){
        System.out.println("joueur 1:");
    }

    public void j2(){
        System.out.println("joueur 2:");
    }

    public void nextTurn(){
        System.out.println("Next Turn:");
    }

    public void mauvaiseSaisie(){
        System.out.println("Mauvaise saisie, relance le jeu!");
    }

    public void choixP4(){
        System.out.println("ou voulez-vous jouer? (de 0 à à 6)");
    }
}
