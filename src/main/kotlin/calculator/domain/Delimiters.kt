package calculator.domain

import calculator.util.RegexUtil.customRegex

class Delimiters(
    private val value: List<String> = listOf(DEFAULT_DELIMITER_COMMA, DEFAULT_DELIMITER_COLONS),
    private val operator: Operator = Operator.PLUS
) {

    fun toOperator(input: String): Operator {
        return if (input in value) {
            operator
        } else {
            throw IllegalArgumentException("등록된 구분자가 아닙니다.")
        }
    }

    companion object {

        private const val DEFAULT_DELIMITER_COMMA = ","
        private const val DEFAULT_DELIMITER_COLONS = ":"

        private const val INDEX_DELIMITER = 1

        fun create(input: String): Delimiters {
            val delimiter = customRegex.find(input)?.run {
                groupValues[INDEX_DELIMITER]
            }

            if (delimiter != null) {
                val delimiters = listOf(
                    DEFAULT_DELIMITER_COMMA,
                    DEFAULT_DELIMITER_COLONS
                ) + delimiter

                return Delimiters(delimiters)
            }
            return Delimiters()
        }
    }
}
