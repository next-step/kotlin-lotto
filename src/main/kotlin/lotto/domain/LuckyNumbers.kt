package lotto.domain

class LuckyNumbers(
    private val luckyNumbers: List<Int>,
    private val bonusNumber: Int
) {
    init {
        require(luckyNumbers.size == LUCKY_NUMBER_SIZE) { "당첨 번호는 ${LUCKY_NUMBER_SIZE}개가 필요합니다." }
        require(luckyNumbers.toSet().size == LUCKY_NUMBER_SIZE) { "당첨 번호에 중복이 있습니다." }
        require(!luckyNumbers.contains(bonusNumber)) { "보너스볼은 당첨번호와 중복될 수 없습니다." }
    }

    fun rank(numbers: List<Int>): LottoRank {
        val hitCount = countHitNumbers(numbers)
        val hasBonusNumber = containsBonusNumber(numbers)
        return LottoRank.from(hitCount, hasBonusNumber)
    }

    private fun countHitNumbers(numbers: List<Int>): Int {
        return numbers.count { number -> luckyNumbers.contains(number) }
    }

    private fun containsBonusNumber(numbers: List<Int>): Boolean {
        return numbers.contains(bonusNumber)
    }

    companion object {
        const val LUCKY_NUMBER_SIZE = 6
    }
}
