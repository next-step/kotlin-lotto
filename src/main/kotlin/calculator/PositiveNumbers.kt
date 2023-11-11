package calculator

data class PositiveNumbers(private val numbers: List<Int>) {
    init {
        numbers.forEach {
            require(it >= POSITIVE_NUMBER_THRESHOLD) {
                "숫자는 0 이상의 양수를 입력해주세요. number: $it"
            }
        }
    }

    fun sum(): Int {
        return numbers.sum()
    }

    companion object {
        private const val POSITIVE_NUMBER_THRESHOLD = 0
    }
}
