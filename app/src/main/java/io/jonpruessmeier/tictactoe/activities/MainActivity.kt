package io.jonpruessmeier.tictactoe.activities

import android.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import io.jonpruessmeier.tictactoe.R
import io.jonpruessmeier.tictactoe.model.Game
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {
    private lateinit var game: Game;
    private lateinit var textViews: Array<Array<TextView>>;
    private lateinit var map: HashMap<String, String>;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val playerOne: String? = intent.getStringExtra("nameOne");
        val playerTwo: String? = intent.getStringExtra("nameTwo");

        if (playerOne != null && playerTwo != null){
            this.game = Game(playerOne, playerTwo);
            fillTextViewArray();

            //instantiating the TextViews for the score of the players:
            val playerOneTextField: TextView = findViewById(R.id.playerOne);
            val playerTwoTextField: TextView = findViewById(R.id.playerTwo);
            playerOneTextField.text = "$playerOne = X";
            playerTwoTextField.text = "$playerTwo = O";

            //filling the map:
            map = HashMap();
            map.put(playerOne, "X");
            map.put(playerTwo, "O");

            playRound(playerOne);



        } else {

            val alertDialogBuilder = AlertDialog.Builder(this)
            alertDialogBuilder.setTitle("No names available")
            alertDialogBuilder.setMessage("One or both names are missing." +
                    " Please provide usernames for the players.")
            alertDialogBuilder.setPositiveButton("OK") { dialog, which ->
                /*
                TODO: RETURN TO StartActivity!
                 */
                dialog.cancel();
            }
            alertDialogBuilder.show()
        }

    }

    private fun fillTextViewArray(): Unit{
        this.textViews = arrayOf(
            arrayOf(
                findViewById(R.id.a_0),
                findViewById(R.id.a_1),
                findViewById(R.id.a_2)
            ),
            arrayOf(
                findViewById(R.id.b_0),
                findViewById(R.id.b_1),
                findViewById(R.id.b_2)
            ),
            arrayOf(
                findViewById(R.id.c_0),
                findViewById(R.id.c_1),
                findViewById(R.id.c_2)
            )
        )
    }

    private fun playRound(player: String): Unit{
        var turnTextView: TextView = findViewById(R.id.turnDisplay);
        turnTextView.text = "It's the turn of $player!";

        for (rows in textViews){
            for (textView in rows){
                textView.setOnClickListener {
                    var view = findViewById<TextView>(it.id);
                    view.text = map.get(player);

                    //switch Players:
                    if (player == game.getPlayers()[0]){
                        playRound(game.getPlayers()[1])
                    } else {
                        playRound(game.getPlayers()[0]);
                    }
                }
            }
        }


    }
}