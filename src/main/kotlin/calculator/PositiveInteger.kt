package calculator

object PositiveInteger {

    fun getPositiveInteger(text: String): Int {
        val number = text.toIntOrNull()
        if (isPositiveInteger(number)) {
            return number!!
        }
        throw RuntimeException()
    }

    private fun isPositiveInteger(number: Int?): Boolean {
        return number != null && number >= 0
    }
}