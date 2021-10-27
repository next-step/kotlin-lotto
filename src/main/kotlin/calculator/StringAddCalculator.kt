package calculator

class StringAddCalculator {

    private val splitHelper = SplitHelper()

    fun add(text: String?): Int {
        if (text.isNullOrEmpty()) {
            return 0
        }

        return splitHelper
            .split(text)
            .sumOf { it.toInt() }
    }
}
