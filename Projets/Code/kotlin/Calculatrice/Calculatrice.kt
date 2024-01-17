package com.example.calcf

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private var input: String = ""
    private var firstNumber: Double = 0.0
    private var operation: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val historique = mutableListOf<Int>()

        val hist1: TextView = findViewById(R.id.hist1)
        val hist2: TextView = findViewById(R.id.hist2)
        val hist3: TextView = findViewById(R.id.hist3)
        val hist4: TextView = findViewById(R.id.hist4)
        val hist5: TextView = findViewById(R.id.hist5)
        val hist6: TextView = findViewById(R.id.hist6)

        val c: Button = findViewById(R.id.C)
        val plus: Button = findViewById(R.id.plus)
        val moin: Button = findViewById(R.id.btnmoin)
        val fois: Button = findViewById(R.id.btnfois)
        val diviser: Button = findViewById(R.id.diviser)

        val resultat: TextView = findViewById(R.id.resultat)
        val egal: Button = findViewById(R.id.egal)

        val btn0: Button = findViewById(R.id.btn0)
        val btn1: Button = findViewById(R.id.btn1)
        val btn2: Button = findViewById(R.id.btn2)
        val btn3: Button = findViewById(R.id.btn3)
        val btn4: Button = findViewById(R.id.btn4)
        val btn5: Button = findViewById(R.id.btn5)
        val btn6: Button = findViewById(R.id.btn6)
        val btn7: Button = findViewById(R.id.btn7)
        val btn8: Button = findViewById(R.id.btn8)
        val btn9: Button = findViewById(R.id.btn9)
        val virgule: Button = findViewById(R.id.virgule)
        val suppr: Button = findViewById(R.id.suppr)



        fun appendToInput(value: String) {
            input += value }

        fun clearInput() {
            input = ""
        }

        fun saveInputToFirstNumber() {
            if (input.isNotEmpty()) {
                firstNumber = input.toDouble()
            }
        }

        fun performOperation(firstNumber: Double, secondNumber: Double, operation: String): Double {
            return when (operation) {
                "+" -> firstNumber + secondNumber
                "-" -> firstNumber - secondNumber
                "*" -> firstNumber * secondNumber 
                "/" -> firstNumber / secondNumber
                else -> 0.0
            }
        }

        fun updateResultView(resultTextView: TextView) {
            try {
                val formattedResult = if (input.isNotEmpty()) {
                    val result = input.toDouble()
                    result.toString()
                } else {
                    ""
                }

                fun clearInput() {
                    input = ""
                    updateResultView(resultat)
                }

                if (operation.isNotEmpty() && firstNumber != 0.0) {
                    resultTextView.text = "$firstNumber $operation $formattedResult"
                } else {
                    resultTextView.text = formattedResult
                }
            } catch (e: NumberFormatException) {

                Toast.makeText(this, "Erreur 0", Toast.LENGTH_SHORT).show()
            }
        }

        c.setOnClickListener {
            try {

                if (input.isNotEmpty()) {
                    input = ""
                    resultat.text = ""
                    c.text = "AC"
                } else {

                    hist1.text = ""
                    hist2.text = ""
                    hist3.text = ""
                    hist4.text = ""
                    hist5.text = ""
                    hist6.text = ""
                }

                if (hist1.text.isEmpty() && hist2.text.isEmpty() && hist3.text.isEmpty() && hist4.text.isEmpty() && hist5.text.isEmpty() && hist6.text.isEmpty()) {
                c.text = "C"

            }
            } catch (e: Exception) {
                Toast.makeText(this, "Erreur 1", Toast.LENGTH_SHORT).show()
            }
        }

        plus.setOnClickListener {
            try {
                saveInputToFirstNumber()
                operation = "+"
                clearInput()
                updateResultView(resultat)
            } catch (e: Exception) {
                Toast.makeText(this, "Erreur 2", Toast.LENGTH_SHORT).show()
            }
        }

        moin.setOnClickListener {
            try {
                saveInputToFirstNumber()
                operation = "-"
                clearInput()
                updateResultView(resultat)
            } catch (e: Exception) {
                Toast.makeText(this, "Erreur 3", Toast.LENGTH_SHORT).show()
            }
        }

        fois.setOnClickListener {
            try {
                saveInputToFirstNumber()
                operation = "*"
                clearInput()
                updateResultView(resultat)
            } catch (e: Exception) {
                Toast.makeText(this, "Erreur 4", Toast.LENGTH_SHORT).show()
            }
        }

        diviser.setOnClickListener {
            try {
                saveInputToFirstNumber()
                operation = "/"
                clearInput()
                updateResultView(resultat)
            } catch (e: Exception) {
                Toast.makeText(this, "Erreur 5", Toast.LENGTH_SHORT).show()
            }
        }

        egal.setOnClickListener {
            try {
                if (operation.isNotEmpty() && input.isNotEmpty()) {
                    val secondNumber = input.toDouble()
                    val result = performOperation(firstNumber, secondNumber, operation)
                    historique.add(0, result.toInt())

                    hist6.text = "${historique.getOrElse(1) { "" }}"
                    hist5.text = "${historique.getOrElse(2) { "" }}"
                    hist4.text = "${historique.getOrElse(3) { "" }}"
                    hist3.text = "${historique.getOrElse(4) { "" }}"
                    hist2.text = "${historique.getOrElse(5) { "" }}"
                    hist1.text = "${historique.getOrElse(6) { "" }}"

                    input = result.toString()
                    operation = ""
                    firstNumber = 0.0
                    updateResultView(resultat)

                    c.text ="C"
                }
            } catch (e: Exception) {
                Toast.makeText(this, "Erreur 6", Toast.LENGTH_SHORT).show()
            }
        }

        btn0.setOnClickListener {
            try {
                appendToInput("0")
                updateResultView(resultat)
            } catch (e: Exception) {
                Toast.makeText(this, "Erreur 8", Toast.LENGTH_SHORT).show()
            }
        }

        btn3.setOnClickListener {
            try {
                appendToInput("3")
                updateResultView(resultat)
            } catch (e: Exception) {
                Toast.makeText(this, "Erreur 8", Toast.LENGTH_SHORT).show()
            }
        }

        btn2.setOnClickListener {
            try {
                appendToInput("2")
                updateResultView(resultat)
            } catch (e: Exception) {
                Toast.makeText(this, "Erreur 8", Toast.LENGTH_SHORT).show()
            }
        }

        btn1.setOnClickListener {
            try {
                appendToInput("1")
                updateResultView(resultat)
            } catch (e: Exception) {
                Toast.makeText(this, "Erreur 9", Toast.LENGTH_SHORT).show()
            }
        }
        btn4.setOnClickListener {
            try {
                appendToInput("4")
                updateResultView(resultat)
            } catch (e: Exception) {
                Toast.makeText(this, "Erreur 10", Toast.LENGTH_SHORT).show()
            }
        }

        btn5.setOnClickListener {
            try {
                appendToInput("5")
                updateResultView(resultat)
            } catch (e: Exception) {
                Toast.makeText(this, "Erreur 11", Toast.LENGTH_SHORT).show()
            }
        }

        btn6.setOnClickListener {
            try {
                appendToInput("6")
                updateResultView(resultat)
            } catch (e: Exception) {
                Toast.makeText(this, "Erreur 12", Toast.LENGTH_SHORT).show()
            }
        }

        btn7.setOnClickListener {
            try {
                appendToInput("7")
                updateResultView(resultat)
            } catch (e: Exception) {
                Toast.makeText(this, "Erreur 13", Toast.LENGTH_SHORT).show()
            }
        }

        btn8.setOnClickListener {
            try {
                appendToInput("8")
                updateResultView(resultat)
            } catch (e: Exception) {
                Toast.makeText(this, "Erreur 14", Toast.LENGTH_SHORT).show()
            }
        }

        btn9.setOnClickListener {
            try {
                appendToInput("9")
                updateResultView(resultat)
            } catch (e: Exception) {
                Toast.makeText(this, "Erreur 15", Toast.LENGTH_SHORT).show()
            }
        }

        virgule.setOnClickListener {
            try {
                if (!input.contains(".")) {
                    if (input.isEmpty()) {
                        appendToInput("0.")
                    } else {
                        appendToInput(".")
                    }
                    updateResultView(resultat)
                }
            } catch (e: Exception) {
                Toast.makeText(this, "Erreur 16", Toast.LENGTH_SHORT).show()
            }

            suppr.setOnClickListener {
                try {
                    if (input.isNotEmpty()) {
                        input = input.substring(0, input.length - 1)
                        updateResultView(resultat)
                    }
                    } catch (e: Exception) {
                        Toast.makeText(this, "Erreur 17", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}
