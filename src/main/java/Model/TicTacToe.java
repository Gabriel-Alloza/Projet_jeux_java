package Model;
import View.View;
import View.InteractionUtilisateur;
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
        boolean is_over = isOver();
        //controller appelle interaction.play()
        String choice = gameController.play();

        while(!is_over){
            if(choice.equals("PVP")){
                boolean P1_ok = false;
                while(!P1_ok) {

                    display();
                    //controller appellle view
                    gameController.J1();

                    if (!getMoveFromPlayer(player1)) {
                        P1_ok = true;
                        is_over = isOver();
                    }

                }
                if(is_over){
                    continue;
                }

                boolean P2_ok = false;
                while(!P2_ok){

                    display();

                    //controller appelle J2
                    gameController.J2();

                    if(!getMoveFromPlayer(player2)){
                        P2_ok = true;
                        is_over = isOver();
                    }

                }
            }




            else if(choice.equals("PVE")){
                boolean P1_ok = false;

                while(!P1_ok) {

                    display();
                    // controller appelle J1
                    gameController.J1();
                    if (!getMoveFromPlayer(player1)) {
                        P1_ok = true;
                        is_over = isOver();
                    }

                }
                if(is_over){
                    continue;
                }

                boolean P2_ok = false;
                int P2_movex = (int)(Math.random()*this.size-1);
                int P2_movey = (int)(Math.random()*this.size-1);
                while(!P2_ok){
                    if(this.cells[P2_movex][P2_movey].getRepresentation().equals("   ")){
                        P2_ok = true;
                        this.cells[P2_movex][P2_movey].setRepresentation(player2.getRepresentation());
                        is_over = isOver();
                    }
                    else{
                        P2_movex = (int)(Math.random()*this.size-1);
                        P2_movey = (int)(Math.random()*this.size-1);
                    }
                }

            }



            else if(choice.equals("EVE")){
                display();

                boolean P1_ok = false;
                int P1_movex = (int)(Math.random()*this.size-1);
                int P1_movey = (int)(Math.random()*this.size-1);
                while(!P1_ok){
                    if(this.cells[P1_movex][P1_movey].getRepresentation().equals("   ")){
                        P1_ok = true;
                        this.cells[P1_movex][P1_movey].setRepresentation(player2.getRepresentation());
                        is_over = isOver();
                    }
                    else{
                        P1_movex = (int)(Math.random()*this.size-1);
                        P1_movey = (int)(Math.random()*this.size-1);
                    }
                }



                boolean P2_ok = false;
                int P2_movex = (int)(Math.random()*this.size-1);
                int P2_movey = (int)(Math.random()*this.size-1);
                while(!P2_ok){
                    if(this.cells[P2_movex][P2_movey].getRepresentation().equals("   ")){
                        P2_ok = true;
                        this.cells[P2_movex][P2_movey].setRepresentation(player2.getRepresentation());
                        is_over = isOver();
                    }
                    else{
                        P2_movex = (int)(Math.random()*this.size-1);
                        P2_movey = (int)(Math.random()*this.size-1);
                    }
                }
                //controller view.nextTurn
                gameController.nextTurn();
            }
            else{
                //controller view.mauvaiseSaisie()
                gameController.mauvaiseSaisie();
                is_over = true;
            }
        }

        display();

    }
}
