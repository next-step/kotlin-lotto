package lotto.data

import lotto.enums.LotteryMatchType

class LottoNumbers(
    numbers: List<Int>
) {
    val lottoNumbers: List<LottoNumber> = numbers.map { LottoNumber.from(it) }

    init {
        require(lottoNumbers.size == LOTTO_NUMBERS_SIZE) { "로또 번호의 개수는 6개여야 합니다." }
        require(!hasDuplicatedNumber()) { "중복되는 숫자는 없어야 합니다." }
    }

    fun findWinningType(winningNumbers: WinningNumbers): LotteryMatchType {
        val matchCount = lottoNumbers.count { winningNumbers.lottoNumbers.contains(it) }
        val hasBonusNumber = lottoNumbers.contains(winningNumbers.bonusNumber)
        return LotteryMatchType.findByMatchCount(matchCount, hasBonusNumber)
    }

    private fun contains(lottoNumber: LottoNumber): Boolean {
        return lottoNumbers.contains(lottoNumber)
    }

    private fun hasDuplicatedNumber(): Boolean {
        lottoNumbers.forEach { lottoNumber ->
            if (isDuplicated(lottoNumber)) return false
        }
        return true
    }

    private fun isDuplicated(lottoNumber: LottoNumber): Boolean {
        val sameNumberCount = lottoNumbers.filter { it == lottoNumber }.count()
        if (sameNumberCount != 1) {
            return true
        }
        return false
    }

    companion object {
        private const val LOTTO_NUMBERS_SIZE = 6
    }
}
