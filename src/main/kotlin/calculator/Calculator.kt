package calculator

import java.lang.RuntimeException

class Calculator {
    val DEFAULT_SEPARATORS = arrayOf(",", ":")

    fun plusAll(expression: String): Int {

        val body: List<String>
        if (hasCustomSeparator(expression)) {
            body = expression.substring(4).split(expression[2].toString())
        } else {
            body = expression.split(*DEFAULT_SEPARATORS)
        }

        val numbers: MutableList<Int> = mutableListOf()
        body.forEach {
            try {
                if (it.toInt() < 0) {
                    throw RuntimeException()
                }
                numbers.add(it.toInt())
            } catch (e: Exception) {
                throw RuntimeException()
            }
        }

        return numbers.sum()
    }

    private fun hasCustomSeparator(value: String): Boolean {
        return value.startsWith("//") &&  value.substring(3).startsWith("\n")
    }
}
