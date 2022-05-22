object LottoProcessor {
    fun apply(tokens: List<Int>): Int {
        return tokens.sumOf { it }
    }
}
