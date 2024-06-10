package za.ac.imadweather

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initialize buttons
        val exitButton = findViewById<Button>(R.id.Exit)
        val nextButton = findViewById<Button>(R.id.Next)

        // Set click listener for the "Next" button
        nextButton.setOnClickListener {
            // Create an intent to navigate to the MainScreen activity
            val intent = Intent(this, MainScreen::class.java)
            // Start the MainScreen activity
            startActivity(intent)
        }

        // Set click listener for the "Exit" button
        exitButton.setOnClickListener {
            // Finish the current activity to exit the application
            finish()
        }
    }
}
