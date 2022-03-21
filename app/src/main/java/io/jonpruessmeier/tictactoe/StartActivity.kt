package io.jonpruessmeier.tictactoe

import android.app.AlertDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class StartActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start)

        val btn: Button = findViewById(R.id.submitNamesButton);
        val nameOne: EditText = findViewById(R.id.editPlayerOne);
        val nameTwo: EditText = findViewById(R.id.editPlayerTwo);

        btn.setOnClickListener {
            var playerOne: String = nameOne.text.toString();
            var playerTwo: String = nameTwo.text.toString();

            if (playerOne == "" || playerTwo == ""){
                //alertWindow
                val alertDialogBuilder = AlertDialog.Builder(this)
                alertDialogBuilder.setTitle("No names available")
                alertDialogBuilder.setMessage("One or both names are missing." +
                        " Please provide usernames for the players.")
                alertDialogBuilder.setPositiveButton("OK") { dialog, which ->
                    dialog.cancel();
                }
                alertDialogBuilder.show()

            } else {
                val intent: Intent = Intent(this, MainActivity::class.java).apply {
                    putExtra("nameOne", playerOne);
                    putExtra("nameTwo", playerTwo);
                }
                startActivity(intent);

            }
        }

    }
}