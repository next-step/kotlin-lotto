package stringCalculator

class ParsedStringValidator {
    fun check(parsedString: List<String>): Boolean {
        return checkNumber(parsedString) && checkNegativeNumber(parsedString)
    }

    private fun checkNumber(parsedString: List<String>): Boolean {
        parsedString.forEach {
            try {
                it.toInt()
            } catch (e: Exception) {
                return false
            }
        }
        return true
    }

    private fun checkNegativeNumber(parsedString: List<String>): Boolean {
        return !parsedString.any { it.toInt() < 0 }
    }
}