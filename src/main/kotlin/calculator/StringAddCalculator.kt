package calculator


class StringAddCalculator {
    @Throws(RuntimeException::class)
    fun add(text: String??): Int {
        if (text.isNullOrBlank()) return 0

        val splitterAndExpression = getSplitterAndExpression(text)

        val splitter = splitterAndExpression.first
        val expression = splitterAndExpression.second

        val numbers = expression.split(Regex(splitter))
        validateNumber(numbers)

        return numbers.map {
            it.toInt()
        }.sum()
    }

    private fun getSplitterAndExpression(text: String): Pair<String, String> {
        val regax = Regex("//(.)\n(.*)").find(text) ?: return Pair(DEFAULT_SPLITTER, text)

        return Pair(regax.groupValues[1], regax.groupValues[2])
    }

    private fun validateNumber(list: List<String>) {
        list.forEach {
            if (it.toInt() < MINIMUM_NUMBER) throw RuntimeException()
        }
    }

    companion object {
        private const val MINIMUM_NUMBER = 0
        private const val DEFAULT_SPLITTER = ",|:";
    }
}