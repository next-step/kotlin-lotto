class StringCalculator {
    @Throws(RuntimeException::class)
    fun add(input: String?): Int {
        if (input.isNullOrBlank()) return 0
        val tokens = if (InputParser.isParsableByDefaultDelimiter(input)) {
            InputParser.parse(input)
        } else {
            InputParser.parseByCustomDelimiter(input)
        }
        InputValidator.validate(tokens)
        return tokens.sumOf { it.toInt() }
    }
}
