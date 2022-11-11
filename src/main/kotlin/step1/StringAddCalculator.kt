package step1

class StringAddCalculator {

    companion object {
        const val DEFAULT_DELIMITER = ","
    }

    fun calculate(input: String?): Int {
        if (input.isNullOrBlank()) {
            return 0
        }

        return input.toInt()
    }
}
