package calculator.domain

class SplitTerms(
    val value: List<String> = listOf(TERMS_COMMA, TERMS_COLONS)
) {

    companion object {
        private const val TERMS_COMMA = ","
        private const val TERMS_COLONS = ":"
    }

}