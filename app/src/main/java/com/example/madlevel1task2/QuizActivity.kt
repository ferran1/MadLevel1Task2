package com.example.madlevel1task2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.EditText
import android.widget.Toast
import com.example.madlevel1task2.databinding.QuizActivityBinding

class QuizActivity : AppCompatActivity() {

    private lateinit var binding: QuizActivityBinding

    private lateinit var firstInput: EditText
    private lateinit var secondInput: EditText
    private lateinit var thirdInput: EditText
    private lateinit var fourthInput: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = QuizActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        firstInput = binding.table.firstInput
        secondInput = binding.table.secondInput
        thirdInput = binding.table.thirdInput
        fourthInput = binding.table.fourthInput

        binding.buttonSubmit.setOnClickListener {
            val amountOfEmptyInputFields = getAmountOfInputFields()
            if (amountOfEmptyInputFields > 0) fieldsAreEmptyToast(amountOfEmptyInputFields) else checkAnswers()
        }


    }

    private fun getAmountOfInputFields(): Int {
        var counter = 0;
        when {
            TextUtils.isEmpty(firstInput.text) -> counter++
            TextUtils.isEmpty(secondInput.text) -> counter++
            TextUtils.isEmpty(thirdInput.text) -> counter++
            TextUtils.isEmpty(fourthInput.text) -> counter++
        }
        return counter
    }

    // Check if the answers are correct and display toasts
    private fun checkAnswers() {

        if (firstInput.text.toString() == "T") {
            Toast.makeText(this, "First answer is correct", Toast.LENGTH_LONG).show()
        } else Toast.makeText(this, "First answer should be \'T\'", Toast.LENGTH_LONG).show()

        if (secondInput.text.toString() == "F") {
            Toast.makeText(this, "Second answer is correct", Toast.LENGTH_LONG).show()
        } else Toast.makeText(this, "Second answer should be \'F\'", Toast.LENGTH_LONG).show()

        if (thirdInput.text.toString() == "F") {
            Toast.makeText(this, "Third answer is correct", Toast.LENGTH_LONG).show()
        } else Toast.makeText(this, "Third answer should be \'F\'", Toast.LENGTH_LONG).show()

        if (fourthInput.text.toString() == "F") {
            Toast.makeText(this, "Fourth answer is correct", Toast.LENGTH_LONG).show()
        } else Toast.makeText(this, "Fourth answer is should be \'F\'", Toast.LENGTH_LONG).show()

    }

    private fun fieldsAreEmptyToast(amountOfEmptyFields: Int) {
        var toastMessage = ""
        if (amountOfEmptyFields == 1) {
            toastMessage =
                "There is one input field not filled in. Please check the inputs and try again."
        } else {
            toastMessage = "There are " + amountOfEmptyFields + " inputs not filled in. " +
                    "Please check the inputs and try again."
        }
        Toast.makeText(this, toastMessage, Toast.LENGTH_LONG).show()
    }
}