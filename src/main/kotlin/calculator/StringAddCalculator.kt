package calculator

class StringAddCalculator {

    fun add(text: String?): Int {
        if (text.isNullOrBlank()) {
            return 0
        }
        val numbers = text.split(",", ":")
        return if (numbers.size == 1) {
            text.toInt()
        } else {
            numbers.map { it.toInt() }.sum()
        }
    }

}
