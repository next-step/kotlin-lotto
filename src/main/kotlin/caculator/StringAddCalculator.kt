package caculator

internal class StringAddCalculator {
    fun add(positiveNumbers: String?): Int {
        if (positiveNumbers.isNullOrEmpty()) {
            return 0
        }

        val numbers = positiveNumbers.split(SPLITTER)
        return numbers.map(String::toInt).sum()
    }

    companion object {
        const val SPLITTER = ","
    }
}
