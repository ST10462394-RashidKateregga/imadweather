package za.ac.imadweather

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class DetailedView : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detailed_view)

        val minTemps = intent.getIntArrayExtra("minTemps")
        val maxTemps = intent.getIntArrayExtra("maxTemps")
        val conditions = intent.getStringArrayExtra("conditions")

        val detailedInfo = findViewById<TextView>(R.id.Detail)

        val detailedText = StringBuilder()
        if (minTemps != null && maxTemps != null && conditions != null) {
            for (i in minTemps.indices) {
                detailedText.append("Day ${i + 1}:\nMin Temp: ${minTemps[i]}, Max Temp: ${maxTemps[i]}, Condition: ${conditions[i]}\n\n")
            }
        }

        detailedInfo.text = detailedText.toString()

        findViewById<Button>(R.id.Back).setOnClickListener {
            finish()
        }
    }
}