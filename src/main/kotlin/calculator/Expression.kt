package calculator

import java.lang.RuntimeException

class Expression(val separators: List<String>, val numbers: List<Int>) {

    companion object {
        val DEFAULT_SEPARATORS = arrayOf(",", ":")
        fun of(value: String): Expression {
            if (hasCustomSeparator(value)) {
                return withCustomSeparator(value)
            }
            return withDefaultSeparator(value)
        }

        private fun withCustomSeparator(value: String): Expression {
            val separator = value[2].toString()
            val operands = value.substring(4).split(value[2].toString())
            try {
                val numbers = operands.map { it.toInt() }
                if (numbers.any { it < 0 }) {
                    throw RuntimeException()
                }
                return Expression(listOf(separator), numbers)
            } catch (e: Exception) {
                throw RuntimeException()
            }
        }

        private fun withDefaultSeparator(value: String): Expression {
            val operands = value.split(*DEFAULT_SEPARATORS)
            try {
                val numbers = operands.map { it.toInt() }
                if (numbers.any { it < 0 }) {
                    throw RuntimeException()
                }
                return Expression(DEFAULT_SEPARATORS.toList(), numbers)
            } catch (e: Exception) {
                throw RuntimeException()
            }
        }

        private fun hasCustomSeparator(value: String): Boolean {
            return value.startsWith("//") && value.substring(3).startsWith("\n")
        }
    }
}
