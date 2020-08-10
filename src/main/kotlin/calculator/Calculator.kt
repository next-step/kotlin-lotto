package calculator

import java.util.regex.Pattern

private const val CUSTOM_SPLITTER_LOCATION = 2
private const val CUSTOM_SPLITTER_LAST_LOCATION = 4
private val CUSTOM_SPLITTER = "//(.)\\n(.*)".toRegex()
private val DEFAULT_SPLITTER = listOf(",", ":")

class Calculator(private var numberInput: String) {
    private var isCustomSplitter: Boolean = false
    private var splitters: List<String> = DEFAULT_SPLITTER
    fun calculate(): Int {
        require(numberInput.isNotEmpty()) { "숫자를 입력해주세요." }
        return try {
            setSplitters()
            validateNumberInput()
            calculate(parsingBySplitters())
        } catch (e: Exception) {
            throw Exception("입력값을 확인하세요.")
        }
    }

    private fun calculate(numbers: List<Number>): Int {
        return numbers.sumBy { it.toInt() }
    }

    private fun validateNumberInput() {
        val pattern = StringBuilder("^[0-9")
        splitters.forEach { pattern.append(it) }
        pattern.append("]*[0-9]$")
        require(Pattern.compile(pattern.toString()).matcher(numberInput).matches())
    }

    private fun setSplitters() {
        if (CUSTOM_SPLITTER.find(numberInput) != null) {
            isCustomSplitter = true
            splitters = listOf(numberInput[CUSTOM_SPLITTER_LOCATION].toString())
            numberInput = numberInput.substring(CUSTOM_SPLITTER_LAST_LOCATION)
        }
    }

    private fun parsingBySplitters(): List<Number> {
        return if (isCustomSplitter) {
            numberInput.split(splitters[0]).map { it.toInt() }
        } else {
            numberInput.split(splitters[0], splitters[1]).map { it.toInt() }
        }
    }
}
