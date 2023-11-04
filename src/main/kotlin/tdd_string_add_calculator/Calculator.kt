package tdd_string_add_calculator

object Calculator {
    fun calculate(express: String): String {
        val list = express.split(SPLIT_REGEX)
        return calculate(list)
    }

    private fun calculate(list: List<String>): String {
        return runCatching {
            list.map { string ->
                val number = changeLettersToNumber(string)
                validateNumber(number)
            }.reduce { acc, i -> acc + i }
                .toString()
        }.getOrElse { throw RuntimeException() }
    }

    private fun changeLettersToNumber(it: String): Int = it.ifBlank { DEFAULT_VALUE }.toInt()

    private fun validateNumber(number: Int) = if (number < 0) throw RuntimeException() else number

    private val SPLIT_REGEX = "([,:])".toRegex()
    private const val DEFAULT_VALUE = "0"
}
