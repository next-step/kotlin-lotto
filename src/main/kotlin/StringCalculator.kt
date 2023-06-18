object StringCalculator {
    @Throws(RuntimeException::class)
    fun add(input: String?): Int {
        if (InputValidator.checkNullOrBlank(input)) return 0

        // non-null 임을 확인했으므로 non-null 임을 보장할 수 있음
        val tokens = InputParser.parse(input!!)
        InputValidator.validate(tokens)
        return tokens.sumOf { it.toInt() }
    }
}
