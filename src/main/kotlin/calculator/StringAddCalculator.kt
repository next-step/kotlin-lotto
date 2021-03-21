package calculator

class StringAddCalculator {

    fun add(text: String?): Int {
        if (text.isNullOrBlank()) {
            return 0
        }
        val numbers = text.split(",")
        if (numbers.size == 1) {
            return text.toInt()
        }
        return 0
    }

}
