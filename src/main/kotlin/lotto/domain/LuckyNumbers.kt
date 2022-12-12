package lotto.domain

import lotto.application.common.Number

class LuckyNumbers(
    luckyNumbers: List<Number>,
    bonusNumber: Number
) {
    private val _luckyNumbers: List<LottoNumber>
    private val _bonusNumber: LottoNumber

    init {
        require(luckyNumbers.size == LUCKY_NUMBER_SIZE) { "당첨 번호는 ${LUCKY_NUMBER_SIZE}개가 필요합니다." }
        require(luckyNumbers.toSet().size == LUCKY_NUMBER_SIZE) { "당첨 번호에 중복이 있습니다." }
        require(!luckyNumbers.contains(bonusNumber)) { "보너스볼은 당첨번호와 중복될 수 없습니다." }

        _luckyNumbers = luckyNumbers.map { LottoNumber(it) }
        _bonusNumber = LottoNumber(bonusNumber)
    }

    fun rank(numbers: List<LottoNumber>): LottoRank {
        val hitCount = countHitNumbers(numbers)
        val hasBonusNumber = containsBonusNumber(numbers)
        return LottoRank.from(hitCount, hasBonusNumber)
    }

    private fun countHitNumbers(numbers: List<LottoNumber>): Number {
        val count = numbers.count { number -> _luckyNumbers.contains(number) }
        return Number(count)
    }

    private fun containsBonusNumber(numbers: List<LottoNumber>): Boolean {
        return numbers.contains(_bonusNumber)
    }

    companion object {
        const val LUCKY_NUMBER_SIZE = 6
    }
}
