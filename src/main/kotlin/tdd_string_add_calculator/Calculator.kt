package tdd_string_add_calculator

object Calculator {
    fun calculate(express: String): String {
        val list = express.split(SPLIT_REGEX)
        return calculate(list)
    }

    private fun calculate(list: List<String>): String =
        runCatching {
            list.map { it.ifBlank { DEFAULT_VALUE }.toInt() }
                .reduce { acc, i -> acc + i }
                .toString()
        }.getOrElse { throw RuntimeException() }

    private val SPLIT_REGEX = "([,:])".toRegex()
    private const val DEFAULT_VALUE = "0"
}
