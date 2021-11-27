package calculator

class StringAddCalculator {
    fun calculate(text: String?): Int {
        if (text.isNullOrBlank())
            return 0

        if (text.matches(NUM_REGEX))
            return text.toInt()

        return 1
    }

    companion object {
        val NUM_REGEX = "\\d+".toRegex()
    }
}
