package calculator

const val DEFAULT_DELIMITER_1 = ','
const val DEFAULT_DELIMITER_2 = ':'
const val DEFAULT_TOKEN_VALUE = 0

object InputConsole {
    fun run(input: String?): List<Int> {
        if (input.isNullOrBlank()) return listOf(DEFAULT_TOKEN_VALUE)
        val inputList = inputToList(input)
        try {
            val result = inputList.map {
                if (it.isNullOrBlank()) DEFAULT_TOKEN_VALUE
                else it.toInt()
            }

            result.forEach {
                if (it < DEFAULT_TOKEN_VALUE) throw java.lang.RuntimeException("token은 0보다 작을 수 없습니다.")
            }

            return result
        } catch (e: NumberFormatException) {
            throw RuntimeException("token은 정수형만 허용합니다")
        }
    }

    private fun inputToList(input: String): List<String?> {
        val regexForCustomDelim = Regex("//(.)\n(.*)").find(input)
        var result: List<String> = listOf()
        regexForCustomDelim?.let {
            val customDelimiter = it.groupValues[1]
            result = it.groupValues[2].split(customDelimiter)
        }

        if (regexForCustomDelim == null) {
            result = input.split(DEFAULT_DELIMITER_1, DEFAULT_DELIMITER_2)
        }

        return result
    }
}
