package comp210.sherwood;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.TableRow;

public class MainActivity extends AppCompatActivity {
    /*
    * we need to know: who's turn is it?
    * Should we place an X or O
    *
    * Clear implmentation
    *
    * nice to have: player order count (player x's turn
    * game over logic
    * */
    boolean playerX = true;
    int col = 3;
    int row = 3;
    square[][] ttt = new square[row][col]; // this will hold the boards content in a gid format
    TableLayout board;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        board = (TableLayout)findViewById(R.id.tttBoard);
        setTags();
    }

    // sets the starting state value
    public void setTags(){
        /* loop is disigned to go through all the cells grid which is a
        *  3 X 3 grid
        * for each cell it will initialize with the blank image*/
        for(int x = 0; x < row; x++ ) {
            TableRow tr = (TableRow) board.getChildAt(x); // will target the cell on the row
            for (int y = 0; y < col; y++) {
                ImageView iv = (ImageView) tr.getChildAt(y); // will target the cell on the column
                ttt[x][y] = new square(x,y);
                ttt[x][y].setReasourceId(R.drawable.blank); // sets cell blank
                iv.setTag(ttt[x][y]); // this will set the id of the col row cell
                iv.setImageResource((R.drawable.blank)); // auto blank
            }
        }
    }

    /* when the user is finished with a game they can click the button to reset the cells
    * turnBlank is similar to set tags, but we don't need the tag decloration since we have
    * already completed that in the above function
    * */
    public void turnBlank(View view){
        for(int x = 0; x < row; x++ ) {
            TableRow tr = (TableRow) board.getChildAt(x); // will target the cell on the row
            for (int y = 0; y < col; y++) {
                ImageView iv = (ImageView) tr.getChildAt(y); // will target the cell on the column
                ttt[x][y].setReasourceId(R.drawable.blank); // sets cell blank
                iv.setImageResource(R.drawable.blank);
            }
        }


    }

    /*
    *  This function will determine what the face value will be x or o
    *  this function is called when the player clicks a square
    * */
    public void changeImage(View view){
        ImageView img = (ImageView) view;
        square current = (square)img.getTag();
        /* if current cell id is equal to id for
           blank let player use x or o
           depending if playerX is true then player places down X
           when playerX is false place down O
         */

        if(current.reasourceId == R.drawable.blank)
        {
            if(playerX) {
                img.setImageResource(R.drawable.x); // if player clicks cell display X
                current.setReasourceId(R.drawable.x); // cell id will match X
            }
            else {
                img.setImageResource(R.drawable.o); // if player clicks cell display O
                current.setReasourceId(R.drawable.o); // cells id will match O
            }

            // check if won function

            playerX = !playerX; // turns playerX value false
        }
    }
}