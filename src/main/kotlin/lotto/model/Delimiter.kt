package lotto.model

class Delimiter(val sixNumberString: String) {
    fun split(): List<String> {
        return splitByComma(sixNumberString)
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
