package lotto.data

import lotto.enums.LotteryMatchType

class LottoNumbers(
    numbers: List<Int>
) {
    val lottoNumbers: List<LottoNumber> = numbers.map { LottoNumber.from(it) }

    init {
        require(lottoNumbers.size == LOTTO_NUMBERS_SIZE) { "로또 번호의 개수는 6개여야 합니다." }
    }

    fun findWinningType(winningNumbers: WinningNumbers): LotteryMatchType {
        val matchCount = lottoNumbers.count { winningNumbers.lottoNumbers.contains(it) }
        val hasBonusNumber = lottoNumbers.contains(winningNumbers.bonusNumber)
        return LotteryMatchType.findByMatchCount(matchCount, hasBonusNumber)
    }

    private fun contains(lottoNumber: LottoNumber): Boolean {
        return lottoNumbers.contains(lottoNumber)
    }

    companion object {
        private const val LOTTO_NUMBERS_SIZE = 6
    }
}
