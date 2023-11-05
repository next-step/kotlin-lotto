class StringAddCalculator {
    fun add(text: String?): Int {
        text ?: return 0
        if (text.isEmpty()) {
            return 0
        }
        val numbers = text.split("[,|:]".toRegex())

        return numbers.sumOf { it.toInt() }
    }
}
