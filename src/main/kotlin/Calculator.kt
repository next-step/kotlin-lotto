class Calculator {

    private val customTokenizerRegex = Regex("//(.)\n(.*)")

    fun calculate(expr: String): Int {
        if (expr.isEmpty()) return 0

        val numberGroup = mutableListOf<String>()
        customTokenizerRegex.find(expr)?.let {
            val customTokenizer = it.groupValues[TOKENIZER_INDEX]
            numberGroup.addAll(it.groupValues[TOKENIZER_APPLIED_EXPR_INDEX].split(customTokenizer))
        } ?: numberGroup.addAll(expr.split(",", ":"))

        if (numberGroup.size == 1) return numberGroup[0].toInt()

        return numberGroup
            .map { it.toInt() }
            .reduce { acc, number ->
                acc + number
            }
    }

    companion object {
        private const val TOKENIZER_INDEX = 1
        private const val TOKENIZER_APPLIED_EXPR_INDEX = 2
    }
}
