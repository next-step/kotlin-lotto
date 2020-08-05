package calculator

import java.lang.NumberFormatException
import java.util.regex.Pattern

const val CUSTOM_SPLITTER_LOCATION = 2
private const val CUSTOM_SPLITTER = "//(.)\\n(.*)"
private val DEFAULT_SPLITTER = listOf(",", ":")
const val CUSTOM_SPLITTER_LAST_LOCATION = 4

class Calculator(private val numbersInput: String) {
    private var isCustomSplitter: Boolean = false
    private var splitters: List<String> = DEFAULT_SPLITTER
    fun execute(): Int {
        getNumbersForCalculator(numbersInput)
        hasCustomSplitter()
        setSplitters()
        hasOnlyValidString()
        val numbers = parsing()
        return calculate(numbers)
    }

    private fun calculate(numbers: List<Number>): Int {
        return numbers.sumBy { it.toInt() }
    }

    private fun getNumbersForCalculator(numbersInput: String): String {
        require(!numbersInput.isBlank()) { throw CalculatorException("숫자를 입력해주세요.") }
        return numbersInput
    }

    private fun hasCustomSplitter() {
        try {
            isCustomSplitter = Pattern.compile(CUSTOM_SPLITTER).matcher(numbersInput).matches()
        } catch (e: CalculatorException) {
            throw CalculatorException("입력값을 확인해 주세요.")
        }
    }

    private fun setSplitters() {
        if (isCustomSplitter) {
            splitters = listOf(numbersInput[CUSTOM_SPLITTER_LOCATION].toString())
        }
    }

    private fun hasOnlyValidString() {
        val pattern = StringBuilder("^[0-9")
        splitters.forEach { pattern.append(it) }
        pattern.append("]*[0-9]$")
        val numberInput = numbersInput.substring(if (isCustomSplitter) CUSTOM_SPLITTER_LAST_LOCATION else 0)
        if (!Pattern.compile(pattern.toString()).matcher(numberInput).matches()) {
            throw CalculatorException("입력값을 확인하세요.")
        }
    }

    private fun parsing(): List<Number> {
        return try {
            if (isCustomSplitter) {
                numbersInput.substring(CUSTOM_SPLITTER_LAST_LOCATION).split(splitters[0]).map { it.toInt() }
            } else {
                numbersInput.replace(splitters[1], splitters[0]).split(splitters[0]).map { it.toInt() }
            }
        } catch (e: NumberFormatException) {
            throw CalculatorException("입력값을 확인하세요.")
        }
    }
}
