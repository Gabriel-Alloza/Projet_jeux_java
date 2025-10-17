package Model;
import Controller.GameController;

public class TicTacToe {
    private int size;
    private Cell[][] cells;
    private Player player1;
    private Player player2;

    /**
     *
     * @param size
     * @param player1
     * @param player2
     *
     * Constructeur de la classe
     */
    public TicTacToe(int size, Player player1, Player player2){

        this.player1 = player1;
        this.player2 = player2;
        this.size = size;
        this.cells = new Cell[this.size][this.size]; //Remplissage du tableau
        for(int i = 0; i < this.size; i++){
            for(int j=0; j < this.size; j++){
                this.cells[i][j] = new Cell("   ");
            }
        }
    }

    /**
     * Affiche le tableau
     */
    public void display(){
       GameController gameController = new GameController();
        gameController.displayBoard(this.size, this.cells, this.size);
    }

    /**
     * Prend la décision d'un joueur, le booléen indique si l'entrée est correcte ou non.
     * @param player
     * @return
     */
    public boolean getMoveFromPlayer(Player player){
        GameController gameController = new GameController();
        return gameController.getMove(this.size, this.cells, player);
    }

    /**
     * Vérifie si les conditions de victoires sont remplies ou non.
     * @return
     */
    public boolean isOver(){

        //colonnes
        //Pour chaque colonne, on teste si toutes les cases contiennent le même symbole, (en s'assurant qu'ucune ne soit vide avant)
        for (int col = 0; col < this.size; col++) {
            String first = cells[col][0].getRepresentation();

            if (first.equals("   ")){
                continue;
            }

            boolean allSame = true;
            for (int row = 1; row < this.size; row++) {
                if (!cells[col][row].getRepresentation().equals(first)) {
                    allSame = false;
                    break;
                }
            }

            if (allSame) {
                return true;
            }
        }

        //lignes
        //Même principe avec les lignes.
        for (int row = 0; row < this.size; row++) {
            String first = cells[0][row].getRepresentation();

            if (first.equals("   ")){
                continue;
            }

            boolean allSame = true;
            for (int col = 1; col < this.size; col++) {
                if (!cells[col][row].getRepresentation().equals(first)) {
                    allSame = false;
                    break;
                }
            }

            if (allSame) {
                return true;
            }
        }


        //diagonales
        //on teste s'il y a des suites de 3 cases identiques en diagonale.
        String init = cells[1][1].getRepresentation();
        if((cells[0][0].getRepresentation().equals(init) && cells[2][2].getRepresentation().equals(init)) || (cells[2][0].getRepresentation().equals(init) && cells[0][2].getRepresentation().equals(init))){
            if(!init.equals("   ")){
                return true;
            }
        }

        //teste tout le plateau est rempli (égalité):
        boolean full = true;
        for(int i = 0; i<this.size; i++){
            for(int j = 0; j<this.size; j++){
                if(cells[i][j].getRepresentation().equals("   ")){
                    full = false;
                    break;
                }
            }
        }
        return full;
    }

    /**
     * Fait tourner le jeu
     */
    public void play(){
        GameController gameController = new GameController();
        boolean isOver = isOver();
        String choice = gameController.play(); //Prend le choix de mmode de jeu

        while(!isOver){ //Boucle du jeu
            if(choice.equals("PVP")){
                boolean p1Ok = false; //teste si la saisie est bonne ou non
                while(!p1Ok) {

                    display(); //Affiche le tableau
                    gameController.j1(); //Affiche "joueur 1":

                    if (!getMoveFromPlayer(player1)) {//teste la saisie
                        p1Ok = true;
                        isOver = isOver();
                    }

                }
                if(isOver){ //Saute le tour du joueur 2 si le joueur 1 a déjà gagné
                    continue;
                }

                //même choses avec le joueur 2
                boolean p2Ok = false;
                while(!p2Ok){

                    display();

                    gameController.j2();

                    if(!getMoveFromPlayer(player2)){
                        p2Ok = true;
                        isOver = isOver();
                    }

                }
            }




            else if(choice.equals("PVE")){
                //Fait joueur le joueur 1 comme pour le PVP
                boolean p1Ok = false;
                while(!p1Ok) {

                    display();
                    gameController.j1();
                    if (!getMoveFromPlayer(player1)) {
                        p1Ok = true;
                        isOver = isOver();
                    }

                }
                if(isOver){
                    continue;
                }


                boolean p2Ok = false; //Teste si le coup du joueur artificiel est possible
                //Donne une case à remplir au hasard par le joueur artificiel
                int p2MoveX = (int)(Math.random()*this.size-1);
                int P2MoveY = (int)(Math.random()*this.size-1);

                while(!p2Ok){
                    if(this.cells[p2MoveX][P2MoveY].getRepresentation().equals("   ")){
                        p2Ok = true;
                        this.cells[p2MoveX][P2MoveY].setRepresentation(player2.getRepresentation());
                        isOver = isOver();
                    }
                    else{ //refait des coups au hasard jusqu'à tomber sur une case vide
                        p2MoveX = (int)(Math.random()*this.size-1);
                        P2MoveY = (int)(Math.random()*this.size-1);
                    }
                }

            }


            //mêmes choses qu'au-dessus avec deux joeurs artificiels.
            else if(choice.equals("EVE")){
                display();

                boolean P1_ok = false;
                int P1MoveX = (int)(Math.random()*this.size-1);
                int P1MoveY = (int)(Math.random()*this.size-1);
                while(!P1_ok){
                    if(this.cells[P1MoveX][P1MoveY].getRepresentation().equals("   ")){
                        P1_ok = true;
                        this.cells[P1MoveX][P1MoveY].setRepresentation(player2.getRepresentation());
                        isOver = isOver();
                    }
                    else{
                        P1MoveX = (int)(Math.random()*this.size-1);
                        P1MoveY = (int)(Math.random()*this.size-1);
                    }
                }



                boolean p2Ok = false;
                int P2MoveX = (int)(Math.random()*this.size-1);
                int P2MoveY = (int)(Math.random()*this.size-1);
                while(!p2Ok){
                    if(this.cells[P2MoveX][P2MoveY].getRepresentation().equals("   ")){
                        p2Ok = true;
                        this.cells[P2MoveX][P2MoveY].setRepresentation(player2.getRepresentation());
                        isOver = isOver();
                    }
                    else{
                        P2MoveX = (int)(Math.random()*this.size-1);
                        P2MoveY = (int)(Math.random()*this.size-1);
                    }
                }
                gameController.nextTurn(); //Affiche "tour suivant"
            }
            else{
                gameController.mauvaiseSaisie(); //Message en cas de mauvause saisie du mode de jeu
                isOver = true;
            }
        }

        display();

    }
}
