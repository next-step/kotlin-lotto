package lotto.model

class Delimiter(private val inputBeforeSplit: String) {
    fun split(): List<String> {
        return splitByComma(inputBeforeSplit)
    }

    private fun splitByComma(stringNumbers: String): List<String> {
        return stringNumbers
            .split(COMMA)
            .map { it.trim() }
    }

    companion object {
        private const val COMMA = ","
    }
}
