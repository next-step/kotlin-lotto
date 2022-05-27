package calculator.splitter

object Splitters {
    fun tokenize(expression: String) = when {
        CustomDelimiterSplitter.isApplicable(expression) -> CustomDelimiterSplitter.trySplit(expression)
        DefaultDelimiterSplitter.isApplicable(expression) -> DefaultDelimiterSplitter.trySplit(expression)
        else -> throw IllegalArgumentException("알맞은 수식어가 아닙니다.")
    }
}
