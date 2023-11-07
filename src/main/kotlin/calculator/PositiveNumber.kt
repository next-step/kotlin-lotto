package calculator

object PositiveNumber {

    private const val NEGATIVE_MESSAGE = "음수 입력되었습니다!!!!"

    fun checkNegativeNumbers(numbers: List<Int>) {
        val negativeNumbers = numbers.filter { it < 0 }
        if (negativeNumbers.isNotEmpty()) throw RuntimeException(NEGATIVE_MESSAGE)
    }
}
