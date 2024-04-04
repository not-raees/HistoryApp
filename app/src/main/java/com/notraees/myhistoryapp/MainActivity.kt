package com.notraees.myhistoryapp


import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.notraees.myhistoryapp.R

class MainActivity : AppCompatActivity() {

    // declare
    private lateinit var searchButton: Button
    private lateinit var resultTextView: TextView
    private lateinit var ageInput: EditText
    private lateinit var clearButton: Button

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)


        //initialise
        searchButton = findViewById(R.id.searchButton)
        clearButton = findViewById(R.id.clearButton)
        ageInput = findViewById(R.id.ageInput)
        resultTextView = findViewById(R.id.resultTextView)


        searchButton.setOnClickListener {
            val age = ageInput.text.toString().toIntOrNull()

            if (age != null && age in 20..100) {
                val famouspersonName = when (age) {
                    85 -> "Hedy Lamarr: Austrian-American actress and inventor, who co-developed a frequency-hopping spread spectrum technology used for secure communications, a precursor to modern wireless communication.\n"
                    41 -> "Alan Turing : English mathematician, logician, and computer scientist, who played a crucial role in cracking Nazi Germany's Enigma code during World War II and is considered one of the fathers of theoretical computer science and artificial intelligence.\n"
                    47 -> "Frida Kahlo (1907-1954): Mexican artist known for her surreal and vibrant paintings, often depicting her own physical and emotional pain, and recognized as one of the most important artists of the 20th century.\n"
                    86 -> "Nikola Tesla (1856-1943): Serbian-American inventor, electrical engineer, and futurist, whose contributions to the development of alternating current (AC) electrical systems paved the way for modern electricity supply systems.\n"
                    87 -> "Coco Chanel (1883-1971): French fashion designer and businesswoman, founder of the Chanel brand, and a key figure in the development of modern fashion, known for her timeless designs and innovative approach to women's clothing.\n"
                    65 -> "Genghis Khan (1162-1227): Founder and first Great Khan of the Mongol Empire, one of the largest contiguous empires in history, known for his military conquests, strategic brilliance, and establishment of a vast trading network.\n"
                    58 -> "Alan Watts (1915-1973): British philosopher, writer, and speaker, best known for popularizing Eastern philosophy for a Western audience and advocating for a deeper understanding of the nature of existence."
                    39 -> "Amelia Earhart (1897-1937?): American aviation pioneer and author, who became the first female aviator to fly solo across the Atlantic Ocean, and disappeared in 1937 while attempting to circumnavigate the globe.\n"
                    32 -> "Srinivasa Ramanujan (1887-1920): Indian mathematician, known for his contributions to mathematical analysis, number theory, infinite series, and continued fractions, often achieving results independently that were already known to others.\n"
                    36 -> "Ada Lovelace (1815-1852): English mathematician and writer, often considered the world's first computer programmer, for her work on Charles Babbage's early mechanical general-purpose computer, the Analytical Engine."
                    else -> null
                }

                val message = if (famouspersonName != null) "You are the same age as $famouspersonName."
                else "No famous person found with the entered age."
                resultTextView.text = message

            } else {
                resultTextView.text = "Invalid input. Please enter a valid age between 20 and 100."
            }
        }

        clearButton.setOnClickListener {
            ageInput.text.clear()
            resultTextView.text = ""
        }
    }
}