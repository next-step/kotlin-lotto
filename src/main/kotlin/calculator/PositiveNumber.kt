package calculator

data class PositiveNumbers(val numbers: List<Int>) {

    fun checkNegativeNumbers() {
        val negativeNumbers = numbers.filter { it < 0 }
        require(negativeNumbers.isEmpty()) { throw RuntimeException(NEGATIVE_MESSAGE) }
    }

    companion object {
        private const val NEGATIVE_MESSAGE = "음수 입력되었습니다!!!!"
    }
}
