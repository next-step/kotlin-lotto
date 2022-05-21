package lotto.domain

import lotto.domain.enums.LottoRank

class WinningLotto(private val lottoNumbers: LottoNumbers, private val bonusNumber: Int) {
    constructor(numbers: List<Int>, bonusNumber: Int) : this(LottoNumbers(numbers), bonusNumber) {
        require(bonusNumber in LottoNumbers.LOTTO_MIN_NUMBER..LottoNumbers.LOTTO_MAX_NUMBER)
    }

    fun match(lotto: Lotto): LottoRank {
        return LottoRank.of(matchingCount(lotto), isMatchBonusNumber(lotto))
    }

    fun match(lottoList: List<Lotto>): List<LottoRank> {
        return lottoList.map { match(it) }
    }

    private fun matchingCount(lotto: Lotto): Int {
        return matchingNumbers(lotto).size
    }

    fun matchingNumbers(lotto: Lotto): List<Int> {
        return lottoNumbers.matchingNumbers(lotto.numbers)
    }

    private fun isMatchBonusNumber(lotto: Lotto): Boolean {
        return bonusNumber in lotto.numbers.numbers
    }
}
