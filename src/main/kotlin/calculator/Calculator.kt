package calculator

import java.util.regex.Pattern

const val FIRST_PREFIX =
    """//"""

const val SECOND_PREFIX =
    """\n"""

const val CUSTOM_SPLITTER_LOCATION = 2
private val DEFAULT_SPLITTER = listOf(",", ":")
const val CUSTOM_SPLITTER_LAST_LOCATION = 5

class Calculator(private val numbersInput: String) {
    private var isCustomSplitter: Boolean = false
    private var splitters: List<String> = emptyList()
    fun execute(): Int {
        getNumbersForCalculator(numbersInput)
        hasCustomSplitter()
        setSplitters()
        hasOnlyValidString()
        checkEndString()
        val numbers = parsing()
        return calculate(numbers)
    }

    private fun calculate(numbers: List<Number>): Int {
        return numbers.sumBy { it.toInt() }
    }

    private fun getNumbersForCalculator(numbersInput: String?): String? {
        require(!numbersInput.isNullOrBlank()) { throw CalculatorException("숫자를 입력해주세요.") }
        return numbersInput
    }

    private fun hasCustomSplitter() {
        try {
            isCustomSplitter = numbersInput.startsWith(FIRST_PREFIX)
                .and(numbersInput.substring(CUSTOM_SPLITTER_LOCATION + 1).startsWith(SECOND_PREFIX))
        } catch (e: IndexOutOfBoundsException) {
            throw CalculatorException("입력값을 확인해 주세요.")
        }
    }

    private fun setSplitters() {
        if (isCustomSplitter) {
            splitters = listOf(numbersInput[CUSTOM_SPLITTER_LOCATION].toString())
        }
        splitters = DEFAULT_SPLITTER
    }

    private fun hasOnlyValidString() {
        val pattern = StringBuilder("^[0-9][0-9")
        splitters.forEach { pattern.append("|$it") }
        pattern.append("]*[0-9]$")
        val numberInput = numbersInput.substring(CUSTOM_SPLITTER_LAST_LOCATION)
        if (!Pattern.compile(pattern.toString()).matcher(numberInput).matches()) {
            throw CalculatorException("입력값을 확인하세요.")
        }
    }

    private fun checkEndString() {
        var numbersInput = this.numbersInput

        if (isCustomSplitter) {
            numbersInput = this.numbersInput.substring(CUSTOM_SPLITTER_LAST_LOCATION)
        }
        if (!numbersInput.last().toString().matches(Regex("[0-9]"))) {
            throw CalculatorException("구분자는 숫자 사이에만 존재합니다.")
        }
        if (!numbersInput.first().toString().matches(Regex("[0-9]"))) {
            throw CalculatorException("구분자는 숫자 사이에만 존재합니다.")
        }
    }

    private fun parsing(): List<Number> {
        if (isCustomSplitter) {
            return numbersInput.substring(CUSTOM_SPLITTER_LAST_LOCATION).split(splitters[0]).map { it.toInt() }
        }
        return numbersInput.replace(splitters[1], splitters[0]).split(splitters[0])
            .map { it.toInt() }
    }
}
