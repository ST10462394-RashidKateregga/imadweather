package za.ac.imadweather

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class DetailedView : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detailed_view)

        // Retrieve data passed from MainScreen
        val minTemps = intent.getIntArrayExtra("minTemps")
        val maxTemps = intent.getIntArrayExtra("maxTemps")
        val conditions = intent.getStringArrayExtra("conditions")

        // Initialize TextView to display detailed information
        val detailedInfo = findViewById<TextView>(R.id.Detail)

        // Build detailed text to display
        val detailedText = StringBuilder()
        if (minTemps != null && maxTemps != null && conditions != null) {
            for (i in minTemps.indices) {
                detailedText.append("Day ${i + 1}:\nMin Temp: ${minTemps[i]}, Max Temp: ${maxTemps[i]}, Condition: ${conditions[i]}\n\n")
            }
        }

        // Set the detailed text to the TextView
        detailedInfo.text = detailedText.toString()

        // Set click listener for the back button to finish the activity and return to MainScreen
        findViewById<Button>(R.id.Back).setOnClickListener {
            finish()
        }
    }
}
