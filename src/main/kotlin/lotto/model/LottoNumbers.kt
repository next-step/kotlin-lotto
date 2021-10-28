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
    }

    private fun checkNumberRange() {
        val numbers = listOf(num1, num2, num3, num4, num5, num6)
        val hasOutOfRangeNumber = numbers.any { num -> num !in MIN_NUMBER..MAX_NUMBER }

        if (hasOutOfRangeNumber) {
            throw IllegalArgumentException("로또 번호는 0 ~ 45 사이의 값만 생성이 가능합니다.")
        }
    }

    companion object {
        private const val MIN_NUMBER = 0
        private const val MAX_NUMBER = 45
    }
}
