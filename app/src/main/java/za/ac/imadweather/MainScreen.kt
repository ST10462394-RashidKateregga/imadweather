package za.ac.imadweather

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainScreen : AppCompatActivity() {

    private lateinit var averageTempView: TextView
    private val minTempInputs = arrayOfNulls<EditText>(7)
    private val maxTempInputs = arrayOfNulls<EditText>(7)
    private val conditionInputs = arrayOfNulls<EditText>(7)

    private val minTemps = IntArray(7)
    private val maxTemps = IntArray(7)
    private val conditions = Array(7) { "" }

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mainscreen)

        averageTempView = findViewById(R.id.Average)

        for (i in 0..6) {
            val minTempId = resources.getIdentifier("minTemp$i", "id", packageName)
            val maxTempId = resources.getIdentifier("maxTemp$i", "id", packageName)
            val conditionId = resources.getIdentifier("condition$i", "id", packageName)

            minTempInputs[i] = findViewById(minTempId)
            maxTempInputs[i] = findViewById(maxTempId)
            conditionInputs[i] = findViewById(conditionId)
        }

        val clearButton = findViewById<Button>(R.id.Clear)
        val calculateButton = findViewById<Button>(R.id.Calculate)
        val viewButton = findViewById<Button>(R.id.View)
        val saveButton = findViewById<Button>(R.id.Save)

        clearButton.setOnClickListener {
            clearInputs()
        }
        calculateButton.setOnClickListener {
            calculateAverage()
        }
        viewButton.setOnClickListener {
            navigateToDetailView()
        }
        saveButton.setOnClickListener {
            saveInputs()
        }
    }

    private fun clearInputs() {
        for (i in 0..6) {
            minTempInputs[i]?.text?.clear()
            maxTempInputs[i]?.text?.clear()
            conditionInputs[i]?.text?.clear()
        }
        averageTempView.text = "Average Temperature: "
        Toast.makeText(this, "Inputs cleared.", Toast.LENGTH_SHORT).show()
    }

    private fun calculateAverage() {
        try {
            var sumMin = 0
            var sumMax = 0
            for (i in 0..6) {
                minTemps[i] = minTempInputs[i]?.text.toString().toInt()
                maxTemps[i] = maxTempInputs[i]?.text.toString().toInt()
                conditions[i] = conditionInputs[i]?.text.toString()

                sumMin += minTemps[i]
                sumMax += maxTemps[i]
            }

            val averageMin = sumMin / 7.0
            val averageMax = sumMax / 7.0

            averageTempView.text = String.format("Average Min: %.2f, Average Max: %.2f", averageMin, averageMax)
        } catch (e: NumberFormatException) {
            Toast.makeText(this, "Please enter valid numbers for temperatures.", Toast.LENGTH_SHORT).show()
        }
    }

    private fun navigateToDetailView() {
        val intent = Intent(this, DetailedView::class.java)
        intent.putExtra("minTemps", minTemps)
        intent.putExtra("maxTemps", maxTemps)
        intent.putExtra("conditions", conditions)
        startActivity(intent)
    }

    private fun saveInputs() {
        // Implement save functionality if needed
        Toast.makeText(this, "Inputs saved.", Toast.LENGTH_SHORT).show()
    }
}
