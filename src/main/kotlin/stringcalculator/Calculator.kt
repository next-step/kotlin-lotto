package stringcalculator

class Calculator {
    fun calculate(rawInput: String?): Int {
        return rawInput?.split(",")!!.sumOf { it.toInt() }
    }
}
