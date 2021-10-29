package calculator.ui

class StringCalculatorView {
    
    fun input(): String = readLine() ?: EMPTY_STRING

    fun output(result: Int) {
        println("$result")
    }

    companion object {
        private const val EMPTY_STRING = ""
    }
}
