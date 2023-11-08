package lotto.domain

@JvmInline
value class WinningNumbers private constructor(
    val value: List<Int>
) {
    fun isInWinningNumbers(number: Int) =
        value.contains(number)
    companion object {
        fun of(
            numbers: List<Int>,
            requiredRange: IntRange = LottoSpec.NUMBERS_RANGE,
            requiredCount: Int = LottoSpec.NUMBERS_COUNT,
        ): WinningNumbers {
            require(numbers.count() == requiredCount) { "로또 당첨 번호 개수는 ${requiredCount}여야 합니다" }
            require(numbers.count() == numbers.distinct().count()) { "로또 당첨 번호는 각기 다른 숫자여야 합니다" }
            checkNumbersRange(numbers, requiredRange)
            return WinningNumbers(numbers)
        }

        private fun checkNumbersRange(numbers: List<Int>, requiredRange: IntRange) {
            numbers.forEach {
                checkNumberInRange(it, requiredRange)
            }
        }

        private fun checkNumberInRange(number:Int, requiredRange: IntRange) {
            require(requiredRange.contains(number)) { "로또 당첨 번호는 $requiredRange 범위 안에 있어야 합니다" }
        }
    }
}
