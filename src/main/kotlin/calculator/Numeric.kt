package calculator

class Numeric {

    companion object {
        fun convertNumeric(expressions: List<String>) = expressions.map { it.toIntOrNull() }
            .ifEmpty { listOf(0) }

        fun List<Int?>.validCheck(): List<Int> {
            if (checkNotNumeric(this)) throw IllegalArgumentException("숫자가 아닌 값이 존재합니다.")
            if (checkMinusNumeric(this)) throw IllegalArgumentException("음수 값이 존재합니다.")
            return this as List<Int>
        }

        private fun checkNotNumeric(expressions: List<Int?>) = expressions.contains(null)

        private fun checkMinusNumeric(expressions: List<Int?>) = expressions.any { it!! < 0 }
    }
}
