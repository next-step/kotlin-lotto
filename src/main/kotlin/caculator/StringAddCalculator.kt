package caculator

internal class StringAddCalculator {
    fun add(positiveNumbers: String?): Int {
        if (positiveNumbers.isNullOrEmpty()) {
            return 0
        }

        return Integer.parseInt(positiveNumbers)
    }
}
