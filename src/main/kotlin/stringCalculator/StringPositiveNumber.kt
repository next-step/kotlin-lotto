package stringCalculator

object StringPositiveNumber {
    fun isPositiveNumber(str: String): Boolean {
        val number = try {
            str.toInt()
        } catch (e: Exception) {
            return false
        }

        return number > 0
    }
}
