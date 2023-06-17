package stringCalculator

class ParsedStringValidator(
    private val parsedString: List<String>
) {
    fun check(): Boolean {
        if (!checkNumber()) {
            return false
        }

        if (!checkNegativeNumber()) {
            return false
        }

        return true
    }

    private fun checkNumber(): Boolean {
        parsedString.forEach {
            try {
                it.toInt()
            } catch (e: Exception) {
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