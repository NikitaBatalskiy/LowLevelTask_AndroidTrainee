package bat.com.lowleveltask

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlin.math.pow
import kotlin.math.sqrt

class FibonacciOutput : AppCompatActivity() {

    companion object {
        const val RADIO_OPTION = "radio_option"
        const val NUMBER_TO_COUNT = "number_to_count"
    }

    private var output: TextView? = null
    private var smallDescription: TextView? = null
    private var returnBack: Button? = null

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fibonacci_output)

        output = findViewById(R.id.output)
        returnBack = findViewById(R.id.returnBack)
        smallDescription = findViewById(R.id.smallDescription)
        val number = intent.getIntExtra(NUMBER_TO_COUNT, 0)

        when (intent.getIntExtra(RADIO_OPTION, 0)) {
            1 -> {
                smallDescription?.text = "Standard way to count - recursive functions"
                output?.append("\nResult number: ${countFibWithRecursiveCall(number)}")
            }
            2 -> {
                smallDescription?.text = "Effective way to count"
                countFibInEffectiveWay(number)
            }
            3 -> {
                smallDescription?.text = "Static formula to count"
                countFibWithStaticFormula(number)
            }
        }
        returnBack?.setOnClickListener {
            super.onBackPressed()
        }
    }

    @SuppressLint("SetTextI18n")
    private fun countFibWithRecursiveCall(number: Int): Long {
        output?.text = "Unfortunately, I couldn't manage to print the output from this function..."
        if (number in 0..1) return number.toLong()
        return countFibWithRecursiveCall(number - 1) + countFibWithRecursiveCall(number - 2)
    }

    @SuppressLint("SetTextI18n")
    private fun countFibInEffectiveWay(number: Int): Long {
        output?.text =
            "Made two vars (temp1 and temp2), equates them to 1," +
                    "\nthen used 'for' loop till the rest of numbers" +
                    "\non each iteration creates new unchangeable var 'sum'" +
                    "\nand equates it to temp1 " +
                    "\ntemp1 equates to sum of itself and temp2" +
                    "\ntemp2 - equates to 'sum'" +
                    "\nFibonacci series: "
        var temp1 = 1
        var temp2 = 1
        output?.append("$temp1, $temp2")
        for (i in 3..number) {
            val sum = temp1
            temp1 += temp2
            temp2 = sum
            output?.append(", $temp1")
        }
        output?.append("\nResult number: $temp1")
        return temp1.toLong()
    }

    @SuppressLint("SetTextI18n")
    private fun countFibWithStaticFormula(number: Int): Long {
        output?.text = "Counting Fibonacci number with a static formula" +
                "\n (phi**n/sqrt of 5) + 0.5, where n - Fib number" +
                "\n and phi - (1+sqrt of 5)/2 "
        val sqr = sqrt(5.0)
        val phi = (sqr + 1) / 2
        val result = (phi.pow(number) / sqr + 0.5).toLong()
        output?.append("\nResult number: $result")
        return result
    }
}