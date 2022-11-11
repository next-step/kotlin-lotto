package step1

class StringAddCalculator {

    companion object {
        const val DEFAULT_DELIMITER = ","
    }

    fun calculate(input: String?): Int {
        if (input.isNullOrBlank()) {
            return 0
        }

        val inputNumberList = input.trim().split(DEFAULT_DELIMITER).asSequence().map { it.toInt() }

        return inputNumberList.sum()
    }
}
