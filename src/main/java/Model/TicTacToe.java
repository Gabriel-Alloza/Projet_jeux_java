package Model;
import View.View;
import Controller.GameController;

public class TicTacToe {
    private int size;
    private Cell[][] cells;
    private Player player1;
    private Player player2;


    public TicTacToe(int size, Player player1, Player player2){

        this.player1 = player1;
        this.player2 = player2;
        this.size = size;
        this.cells = new Cell[this.size][this.size];
        for(int i = 0; i < this.size; i++){
            for(int j=0; j < this.size; j++){
                this.cells[i][j] = new Cell("   ");
            }
        }
    }

    public void display(){
       GameController gameController = new GameController();
        //contrller appelle view.displayboard()
        gameController.displayBoard(this.size, this.cells, this.size);
        // End display
    }

    public boolean getMoveFromPlayer(Player player){
        GameController gameController = new GameController();
        return gameController.getMove(this.size, this.cells, player);
    }


    public boolean isOver(){

        //colones
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
        String init = cells[1][1].getRepresentation();
        if((cells[0][0].getRepresentation().equals(init) && cells[2][2].getRepresentation().equals(init)) || (cells[2][0].getRepresentation().equals(init) && cells[0][2].getRepresentation().equals(init))){
            if(!init.equals("   ")){
                return true;
            }
        }

        //teste s'il y a une égalité:
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


    public void play(){
        View view = new View();
        GameController gameController = new GameController();
        boolean isOver = isOver();
        //controller appelle interaction.play()
        String choice = gameController.play();

        while(!isOver){
            if(choice.equals("PVP")){
                boolean p1Ok = false;
                while(!p1Ok) {

                    display();
                    //controller appellle view
                    gameController.j1();

                    if (!getMoveFromPlayer(player1)) {
                        p1Ok = true;
                        isOver = isOver();
                    }

                }
                if(isOver){
                    continue;
                }

                boolean p2Ok = false;
                while(!p2Ok){

                    display();

                    //controller appelle J2
                    gameController.j2();

                    if(!getMoveFromPlayer(player2)){
                        p2Ok = true;
                        isOver = isOver();
                    }

                }
            }




            else if(choice.equals("PVE")){
                boolean p1Ok = false;

                while(!p1Ok) {

                    display();
                    // controller appelle J1
                    gameController.j1();
                    if (!getMoveFromPlayer(player1)) {
                        p1Ok = true;
                        isOver = isOver();
                    }

                }
                if(isOver){
                    continue;
                }

                boolean p2Ok = false;
                int p2MoveX = (int)(Math.random()*this.size-1);
                int P2MoveY = (int)(Math.random()*this.size-1);
                while(!p2Ok){
                    if(this.cells[p2MoveX][P2MoveY].getRepresentation().equals("   ")){
                        p2Ok = true;
                        this.cells[p2MoveX][P2MoveY].setRepresentation(player2.getRepresentation());
                        isOver = isOver();
                    }
                    else{
                        p2MoveX = (int)(Math.random()*this.size-1);
                        P2MoveY = (int)(Math.random()*this.size-1);
                    }
                }

            }



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
                //controller view.nextTurn
                gameController.nextTurn();
            }
            else{
                //controller view.mauvaiseSaisie()
                gameController.mauvaiseSaisie();
                isOver = true;
            }
        }

        display();

    }
}
