import java.io.*;

public class Solver {
    private int[][] board = new int[9][9];

    private void fillBoard(){

        try {
            BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
            String fileName = null;
            System.out.println("Enter the name of the file for the Sudoku board.");
            fileName = console.readLine();
            File file = new File("./Test Boards/" + fileName + ".txt" );
            FileReader fileRead = new FileReader ( file );
            BufferedReader fileReader = new BufferedReader( fileRead );

            char element =' ';
            int row = 0, column = 0;
            while( ( element = (char) fileReader.read()) != '\uFFFF' ){

                if( element == '\n' ){
                    row++;
                    column = 0;
                    continue;
                }

                if( element == ',' || element == ' ' || element == '\r'){
                    continue;
                }else if( element == '-' ){
                    board[row][column] = 0;
                }else{
                    if( Character.isDigit(element) ){
                        board[row][column] = Character.getNumericValue( element );
                    }else{
                        System.out.println("Invalid input to board!");
                        System.exit('A');
                    }
                }
                column++;
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }

    }

    private void printBoard(){

        int element;
        for(int r = 0; r < 9; r++){
            for(int c = 0; c < 8; c++){
                element = board[r][c];
                System.out.print(element + ", ");
            }

            element = board[r][8];
            System.out.print( element );
            System.out.println();
        }

    }

    private void solve(){
        fillBoard();
        printBoard();
    }

    public void run(){ solve(); }

}
