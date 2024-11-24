package step1

class Calculator(expression: String) {
    private val numbers: List<Int>

    init{
        numbers = expression.split(",", ":")
            .filter { it.isNotEmpty() }
            .map { it.toInt() }
    }

    fun sum(): Int {
        return numbers.sum()
    }
}
