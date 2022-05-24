package calculator

class StringAddCalculator {

    fun add(text: String?) : Int {
        if(text.isNullOrBlank()) {
            return ZERO
        }
        val numbers = getStringListWithDefinedRegx(text).map { string -> string.toInt() }
        return numbers.sum()
    }

    private fun getStringListWithDefinedRegx(text: String) : List<String> {
        return text.split(",|:".toRegex())
    }

    companion object {
        private const val ZERO = 0
    }
}
