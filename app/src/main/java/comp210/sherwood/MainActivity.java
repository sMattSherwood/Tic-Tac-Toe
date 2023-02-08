package comp210.sherwood;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    /*
    * we need to know: who's turn is it?
    * Should we place an X or O
    *
    * Clear implmentation
    * */
    boolean playerX = true;
    int col = 3;
    int row = 3;
    square[][] tttBoard; // this will hold the boards content in a gid format

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTags();
    }

    // sets the starting state value
    public void setTags(){
        /* loop is disigned to go through all the cells grid which is a
        *  3 X 3 grid
        * for each cell it will initialize with the blank image*/
        for(int x = 0; x < row; x++ ) {
            for (int y = 0; y < col; y++) {
                tttBoard[x][y] = new square(x,y);
                tttBoard[x][y].setReasourceId(R.drawable.blank);

            }
        }

    }

    /*
    *  This function will determine what the face value will be x or o
    *  this function is called when the player clicks a square
    * */
    public void changeImage(View view){
        ImageView img = (ImageView) view;
        if(playerX)
            img.setImageResource(R.drawable.x); // if player one clicks it will display x
        else
            img.setImageResource(R.drawable.o);

        playerX = !playerX; // makes playerx false
    }
}