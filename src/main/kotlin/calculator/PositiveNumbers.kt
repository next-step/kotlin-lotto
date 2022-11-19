package calculator

data class PositiveNumbers(private val value: List<Int>) {
    fun sum(): Int {
        return value.sum()
    }

    companion object {
        fun parse(numbers: List<Int>): PositiveNumbers {
            if(hasNegativeNumber(numbers)) {
               throw RuntimeException("음수는 입력할 수 없습니다.")
            }

            return PositiveNumbers(numbers)
        }

        private fun hasNegativeNumber(numbers: List<Int>): Boolean {
            return numbers.any { number -> number < 0 }
        }
    }
}