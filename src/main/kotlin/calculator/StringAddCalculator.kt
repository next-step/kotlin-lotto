package calculator

class StringAddCalculator {

    fun add(text: String?): Int {
        if (text.isNullOrBlank()) {
            return 0
        }

        val numbers = text.split(DELIMITER).map { it.toInt() }
        return numbers.sum()
    }

    companion object {
        private val DELIMITER = "[,:]".toRegex()
    }
}
