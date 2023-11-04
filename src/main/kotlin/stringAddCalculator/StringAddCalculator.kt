package stringAddCalculator

class StringAddCalculator private constructor() {

    fun calculate(input: String?): Int {
        if (input.isNullOrEmpty()) {
            return EMPTY_RESULT
        }

        return StringAddCalculatorInput(input).parse().sumOf { it }
    }

    companion object {
        private const val EMPTY_RESULT = 0

        @Volatile
        private var instance: StringAddCalculator? = null

        fun getInstance() =
            instance ?: synchronized(this) {
                instance ?: StringAddCalculator().also { instance = it }
            }
    }
}
