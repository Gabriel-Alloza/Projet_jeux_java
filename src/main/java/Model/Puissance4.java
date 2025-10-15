package Model;
import View.View;
import View.InteractionUtilisateur;

public class Puissance4 {

    private int size;
    private int longueur;
    private Cell[][] cells;
    private Player player1;
    private Player player2;


    public Puissance4(int size, int longueur, Player player1, Player player2){

        this.player1 = player1;
        this.player2 = player2;
        this.size = size;
        this.longueur = longueur;

        this.cells = new Cell[this.size][this.longueur];
        for(int i = 0; i < this.size; i++){
            for(int j=0; j < this.longueur; j++){
                this.cells[i][j] = new Cell("   ");
            }
        }
    }

    public void displayBoard(){
        View view = new View();
        view.displayboard(this.size, this.cells, this.longueur);
    }

    public boolean hasWon(){

        //colones
        for(int col = 0; col<7; col++){
            for(int row = 0; row < 3; row ++){
                if(!this.cells[row][col].getRepresentation().equals("   ")){
                    if(this.cells[row][col].getRepresentation().equals(this.cells[row + 1][col].getRepresentation())){
                        if(this.cells[row + 1][col].getRepresentation().equals(this.cells[row + 2][col].getRepresentation())){
                            if(this.cells[row + 2][col].getRepresentation().equals(this.cells[row + 3][col].getRepresentation())){
                                return true;
                            }
                        }
                    }
                }
            }
        }

        //lignes
        for(int row = 0; row < 6; row ++){
            for(int col = 0; col < 4; col ++){
                if(!this.cells[row][col].getRepresentation().equals("   ")){
                    if(this.cells[row][col].getRepresentation().equals(this.cells[row][col + 1].getRepresentation())){
                        if(this.cells[row][col + 1].getRepresentation().equals(this.cells[row][col + 2].getRepresentation())){
                            if(this.cells[row][col + 2].getRepresentation().equals(this.cells[row][col + 3].getRepresentation())){
                                return true;
                            }
                        }
                    }
                }
            }
        }

        Cell[] diag1 = new Cell[4];
        for(int row = 3; row>0; row --){
            for(int col = 0; col<=3; col ++){
                diag1[col] = new Cell(this.cells[row][col].getRepresentation());
            }
        }

        if(!diag1[0].getRepresentation().equals("   ")){
            if(diag1[0].getRepresentation().equals(diag1[1].getRepresentation())){
                if(diag1[1].getRepresentation().equals(diag1[2].getRepresentation())){
                    if(diag1[2].getRepresentation().equals(diag1[3].getRepresentation())){
                        return true;
                    }
                }
            }
        }









        return false;
    }

    public void play(Player player1, Player player2){
        InteractionUtilisateur interaction = new InteractionUtilisateur();
        View view = new View();

        Player current_player = player2;
        boolean hasWon = hasWon();

        boolean inputError = false;
        while(!hasWon){
            hasWon = hasWon();

            if(!inputError){
                if(current_player == player1){
                    current_player = player2;
                }
                else {
                    current_player = player1;
                }
            }

            inputError = false;
            displayBoard();
            view.choixP4();
            int player_choice = interaction.inputInteger();
            if(player_choice<0 || player_choice > 6){
                view.mauvaiseEntree();
                inputError = true;
            }
            else
            {
                for (int row = 5; row >= 0; row--) {
                    String last = cells[row][player_choice].getRepresentation();
                    if(last.equals("   ")){
                        cells[row][player_choice].setRepresentation(current_player.getRepresentation());
                        hasWon = hasWon();
                        break;
                    }
                }
            }
        }
    }
}
