package calculator

class StringAddCalculator {

    fun add(text: String?): Int {
        if (isBlank(text)) return 0

        return -1
    }

    private fun isBlank(text: String?): Boolean = text.isNullOrBlank()

}
