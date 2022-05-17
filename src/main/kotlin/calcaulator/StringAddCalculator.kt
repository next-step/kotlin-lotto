package calcaulator

class StringAddCalculator {
    fun add(text: String?): Int {
        if (text.isNullOrEmpty()) {
            return 0
        }

        return text.split(Regex(",|:")).map { it.trim().toInt() }
            .reduce { a, b -> a + b }
    }
}
