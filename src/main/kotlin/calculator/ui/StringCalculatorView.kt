package calculator.ui

object StringCalculatorView {

    fun input(): String = readLine() ?: EMPTY_STRING

    fun output(result: Int) {
        println("$result")
    }

    private const val EMPTY_STRING = ""
}
