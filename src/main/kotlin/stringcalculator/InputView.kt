package stringcalculator

class InputView {
    fun getExpressionInput(): String = getInputMessage(CALCULATE_INPUT)

    private fun getInputMessage(requestMessage: String): String {
        println(requestMessage)
        val input = readlnOrNull()?.trim()?.replace("\\n", "\n")
        if (input.isNullOrEmpty()) throw IllegalArgumentException("입력이 없습니다.")
        return input
    }

    private companion object {
        const val CALCULATE_INPUT = "Enter input: "
    }
}
