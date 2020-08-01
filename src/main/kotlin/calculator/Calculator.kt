package calculator

import java.lang.IllegalArgumentException

private const val FIRST_PREFIX =
    """//"""

private const val SECOND_PREFIX =
    """\n"""

private const val CUSTOM_SPLITTER_LOCATION = 2
private const val CUSTOM_SPLITTER_LAST_LOCATION = 5
// try {
//        println("계산하기 위한 문자열을 입력해주세요.")
//        val calculator = Calculator(readLine()!!)
//        val result = calculator.execute()
//        println("총합은 $result 입니다.")
//    } catch (e: Exception) {
//        println(e.message)
//    }

class Calculator(private val numbersInput: String?) {

    private val DEFAULT_SPLITTERS = listOf(",", ":")
    private var isCustomSplitter: Boolean = false

    fun execute(): Int {
        getNumbers(numbersInput)
        hasCustomSplitter()
        hasOnlyValidString()
        checkEndString()
        val numbers = parsing()
        return calculate(numbers)
    }

    private fun calculate(numbers: List<Int>): Int {
        return numbers.sum()
    }

    private fun getNumbers(numbersInput: String?): String? {
        require(!numbersInput.isNullOrBlank()) { throw IllegalArgumentException("숫자를 입력해주세요.") }
        return numbersInput
    }

    private fun hasCustomSplitter() {
        try {
            isCustomSplitter = numbersInput!!.startsWith(FIRST_PREFIX)
                .and(numbersInput.substring(CUSTOM_SPLITTER_LOCATION + 1).startsWith(SECOND_PREFIX))
        } catch (e: IndexOutOfBoundsException) {
            throw CalculatorException("입력값을 확인하세요.")
        }
    }

    private fun getSplitters(): List<String> {
        if (isCustomSplitter) {
            return listOf(numbersInput!![CUSTOM_SPLITTER_LOCATION].toString())
        }
        return DEFAULT_SPLITTERS
    }

    private fun hasOnlyValidString() {
        val pattern = StringBuilder("[0-9")
        getSplitters().forEach { pattern.append("|$it") }
        pattern.append("]*")
        val numberInput = numbersInput!!.substring(CUSTOM_SPLITTER_LAST_LOCATION)

        if (!numberInput.matches(Regex(pattern.toString()))) {
            throw CalculatorException("입력값을 확인하세요.")
        }
    }

    private fun checkEndString() {
        var numbersInput = this.numbersInput

        if (isCustomSplitter) {
            numbersInput = this.numbersInput!!.substring(CUSTOM_SPLITTER_LAST_LOCATION)
        }
        if (!numbersInput!!.last().toString().matches(Regex("[0-9]"))) {
            throw CalculatorException("입력값을 확인하세요.")
        }
        if (!numbersInput.first().toString().matches(Regex("[0-9]"))) {
            throw CalculatorException("입력값을 확인하세요.")
        }
    }

    private fun parsing(): List<Int> {
        if (isCustomSplitter) {
            return numbersInput!!.substring(CUSTOM_SPLITTER_LAST_LOCATION).split(getSplitters()[0]).map { it.toInt() }
        }
        return numbersInput!!.replace(getSplitters()[1], getSplitters()[0]).split(getSplitters()[0])
            .map { it.toInt() }
    }
}
