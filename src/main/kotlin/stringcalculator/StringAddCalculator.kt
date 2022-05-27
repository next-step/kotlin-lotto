package stringcalculator

class StringAddCalculator {

    fun add(text: String?): Int {
        if (text.isNullOrBlank()) {
            return ZERO
        }
        return text.toInt()
    }

    companion object {
        private const val ZERO = 0
    }
}
