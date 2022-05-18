package calculator

class Calculator {
    fun add(expression: String): Int {

        if (expression.isBlank()) {
            return 0
        }

        return expression.split("[,:]".toRegex())
            .sumOf { it.toInt() }
    }
}
