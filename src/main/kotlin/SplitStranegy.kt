enum class ExpressionSplitStrategy(
    val split: (Expression) -> List<String>
) {

    BASIC({ expression ->
        val expressionReplace = expression.value
            .replace(SPLIT_TERMS_COLONS, SPLIT_RESULT)
            .replace(SPLIT_TERMS_COMMA, SPLIT_RESULT)

        expressionReplace.split(SPLIT_TERMS_EMPTY)
    }),
    CUSTOM({

        listOf()
    });

    companion object {
        private const val SPLIT_TERMS_COLONS = ":"
        private const val SPLIT_TERMS_EMPTY = ""
        private const val SPLIT_TERMS_COMMA = ","

        private const val SPLIT_RESULT = ""
    }

}