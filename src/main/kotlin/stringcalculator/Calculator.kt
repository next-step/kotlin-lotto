package stringcalculator

class Calculator {
    fun calculate(rawInput: String?): Int {
        return rawInput?.split(*DEFAULT_DELIMITERS)!!.sumOf { it.toInt() }
    }

    companion object {
        private val DEFAULT_DELIMITERS = arrayOf(",", ":")
    }
}
