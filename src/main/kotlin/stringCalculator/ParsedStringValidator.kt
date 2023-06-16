package stringCalculator

class ParsedStringValidator(
    private val parsedString: List<String>
) {
    fun check() {
        if (!checkNumber()) {
            throw RuntimeException()
        }

        if (!checkNegativeNumber()) {
            throw RuntimeException()
        }
    }

    private fun checkNumber(): Boolean {
        parsedString.forEach {
            try {
                it.toInt()
            } catch (e: RuntimeException) {
                return false
            }
        }
        return true
    }

    private fun checkNegativeNumber(): Boolean {
        if (parsedString.any { it.toInt() < 0 }) {
            return false
        }
        return true
    }
}