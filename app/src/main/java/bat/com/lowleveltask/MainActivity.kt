package bat.com.lowleveltask

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*

class MainActivity : AppCompatActivity() {

    private var inputNumber: EditText? = null
    private var option1: RadioButton? = null
    private var option2: RadioButton? = null
    private var option3: RadioButton? = null
    private var countFibonacci: Button? = null
    private var output: TextView? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        inputNumber = findViewById(R.id.inputNumber)
        option1 = findViewById(R.id.option1)
        option2 = findViewById(R.id.option2)
        option3 = findViewById(R.id.option3)
        countFibonacci = findViewById(R.id.countFibonacci)
        output = findViewById(R.id.output)
        var optionCheckedPosition = 0

        countFibonacci?.setOnClickListener {
            if (inputNumber?.text.isNullOrEmpty())
                Toast.makeText(
                    applicationContext,
                    "Enter number, please",
                    Toast.LENGTH_LONG
                ).show()
            else {
                val number: Int = inputNumber?.text.toString().toInt()
                val intent = Intent(this, FibonacciOutput::class.java)
                intent.putExtra(FibonacciOutput.NUMBER_TO_COUNT, number)
                when {
                    option1?.isChecked == true -> {
                        optionCheckedPosition = 1
                        intent.putExtra(FibonacciOutput.RADIO_OPTION, optionCheckedPosition)
                        startActivity(intent)
                    }
                    option2?.isChecked == true -> {
                        optionCheckedPosition = 2
                        intent.putExtra(FibonacciOutput.RADIO_OPTION, optionCheckedPosition)
                        startActivity(intent)
                    }
                    option3?.isChecked == true -> {
                        optionCheckedPosition = 3
                        intent.putExtra(FibonacciOutput.RADIO_OPTION, optionCheckedPosition)
                        startActivity(intent)
                    }
                    else -> Toast.makeText(
                        applicationContext,
                        "Choose the way to count, please",
                        Toast.LENGTH_LONG
                    ).show()
                }
            }
        }
    }
}