package calcaulator

class StringAddCalculator {
    fun add(text: String?): Int {
        if (text.isNullOrEmpty()) {
            return 0
        }

        return text.split(",").map { it.trim().toInt() }
            .reduce { a, b -> a + b }
    }
}
