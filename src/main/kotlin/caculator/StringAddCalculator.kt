package caculator

internal class StringAddCalculator(private val splitters: List<String> = DEFAULT_SPLITTERS) {

    fun add(positiveNumbers: String?): Int {
        if (positiveNumbers.isNullOrEmpty()) {
            return 0
        }
        val numbers = positiveNumbers.split(*this.splitters.toTypedArray())
        return numbers.map(String::toInt).sum()
    }

    companion object {
        private val DEFAULT_SPLITTERS = listOf(",", ":")
    }
}
