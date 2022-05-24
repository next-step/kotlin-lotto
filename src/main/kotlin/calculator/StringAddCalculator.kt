package calculator

class StringAddCalculator {
    fun add(text: String?) : Int {
        if(text.isNullOrBlank()) {
            return ZERO
        }
        return 0
    }

    companion object {
        private const val ZERO = 0
    }
}
