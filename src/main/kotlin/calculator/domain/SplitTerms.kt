package calculator.domain

class SplitTerms(
    val value: List<String> = listOf(TERMS_COMMA, TERMS_COLONS)
) {

    companion object {
        fun create(input: String): SplitTerms {
            val terms = Regex("//(.)\n(.*)").find(input)?.run {
                groupValues[1]
            }

            println("create $terms")
            return if (terms != null) {
                SplitTerms(listOf(TERMS_COMMA, TERMS_COLONS) + terms)
            } else {
                SplitTerms()
            }
        }

        private const val TERMS_COMMA = ","
        private const val TERMS_COLONS = ":"
    }

}