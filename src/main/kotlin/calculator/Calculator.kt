package calculator

import java.util.regex.Pattern

private const val CUSTOM_SPLITTER_LOCATION = 2
private val CUSTOM_SPLITTER = "//(.)\\n(.*)".toRegex()
private val DEFAULT_SPLITTER = listOf(",", ":")
private const val CUSTOM_SPLITTER_LAST_LOCATION = 4

class Calculator(private val numbersInput: String) {
    private var isCustomSplitter: Boolean = false
    private var splitters: List<String> = DEFAULT_SPLITTER
    fun execute(): Int {
        validateNumberInput(numbersInput)
        setSplitters()
        hasOnlyValidString()
        return calculate(parsing())
    }

    private fun calculate(numbers: List<Number>): Int {
        return numbers.sumBy { it.toInt() }
    }

    private fun validateNumberInput(numbersInput: String): String {
        require(numbersInput.isNotEmpty()) { "숫자를 입력해주세요." }
        return numbersInput
    }

    private fun setSplitters() {
        if (CUSTOM_SPLITTER.matches(numbersInput)) {
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
            val numbersInput =
                if (isCustomSplitter) numbersInput.substring(CUSTOM_SPLITTER_LAST_LOCATION) else numbersInput.replace(
                    splitters[1],
                    splitters[0]
                )
            numbersInput.split(splitters[0], splitters[1]).map { it.toInt() }
        } catch (e: CalculatorException) {
            throw CalculatorException("입력값을 확인하세요.")
        }
    }
}
