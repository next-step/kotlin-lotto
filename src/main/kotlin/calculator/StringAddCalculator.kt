package calculator

class StringAddCalculator {
    @Throws(RuntimeException::class)
    fun add(text: String??): Int {
        if (text.isNullOrBlank()) return 0

        val splitterAndExpression = getSplitterAndExpression(text)

        val splitter = splitterAndExpression.first
        val expression = splitterAndExpression.second

        val numbers = expression.split(Regex(splitter)).toTypedArray()

        val stringNumberCollection = StringNumberCollection(numbers)

        return stringNumberCollection.sum()
    }

    private fun getSplitterAndExpression(text: String): Pair<String, String> {
        val regax = Regex("//(.)\n(.*)").find(text) ?: return Pair(DEFAULT_SPLITTER, text)

        return Pair(regax.groupValues[1], regax.groupValues[2])
    }

    companion object {
        private const val DEFAULT_SPLITTER = ",|:"
    }
}
