package lotto.model

data class LottoNumbers(
    val num1: Int,
    val num2: Int,
    val num3: Int,
    val num4: Int,
    val num5: Int,
    val num6: Int
) {

    init {
        checkNumberRange()
        checkDuplicate()
    }

    private fun checkNumberRange() {
        val numbers = asList()
        val hasOutOfRangeNumber = numbers.any { num -> num !in MIN_NUMBER..MAX_NUMBER }

        require(!hasOutOfRangeNumber)
    }

    private fun checkDuplicate() {
        val numbers = asList()
        val distinctSize = numbers.distinct().size

        require(distinctSize == LOTTO_SIZE)
    }

    private fun asList(): List<Int> = listOf(num1, num2, num3, num4, num5, num6)

    companion object {
        private const val LOTTO_SIZE = 6
        private const val MIN_NUMBER = 0
        private const val MAX_NUMBER = 45
    }
}
