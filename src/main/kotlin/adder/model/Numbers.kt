package adder.model

data class Numbers(val nums: List<Number>) {
    constructor(input: Collection<String>) : this(input.map(::Number))

    constructor(input: String) : this(splitByDefault(input))

    fun getSum(): Int {
        return nums.sumBy { it.value }
    }

    companion object {
        private const val REGEX_FOR_DELIMITER = "^//.\\n"
        private const val DELIMITER_1 = ","
        private const val DELIMITER_2 = ";"

        private fun splitByDefault(input: String): List<String> {
            val matches = input.matches(Regex(REGEX_FOR_DELIMITER))
            require(!matches).apply { return input.split(DELIMITER_1, DELIMITER_2) }
        }
    }
}
