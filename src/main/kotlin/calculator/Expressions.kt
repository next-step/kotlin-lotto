package calculator

import calculator.Number.Companion.ZERO

class Expressions(val expressions: List<Int>) {
    init {
        validateOverThanZero()
    }

    private fun validateOverThanZero() {
        expressions.forEach {
            if (it < ZERO) {
                throw RuntimeException("음수는 입력할 수 없습니다. input = $it")
            }
        }
    }

    fun sum(): Int {
        return expressions.sumOf { it }
    }

    companion object {
        fun created(
            expression: String,
            regex: Regex,
        ): Expressions {
            if (expression.isBlank()) {
                return Expressions(emptyList())
            }
            return Expressions(expression.split(regex).map { it.toInt() })
        }
    }
}
