package tdd_string_add_calculator

object Calculator {
    fun calculate(express: String): String {
        val list = express.split(SPLIT_REGEX)
        return list.map { it.toInt() }.reduce { acc, i -> acc + i }.toString()
    }

    private val SPLIT_REGEX = "([,:])".toRegex()
}
