package lotto.domain

class WinningLotto(private val lottoNumbers: LottoNumbers, private val bonusNumber: Int) {
    constructor(numbers: List<Int>, bonusNumber: Int) : this(LottoNumbers(numbers), bonusNumber) {
        require(bonusNumber in LottoNumbers.LOTTO_MIN_NUMBER..LottoNumbers.LOTTO_MAX_NUMBER)
    }

    fun match(lotto: Lotto): LottoMatchResult {
        return LottoMatchResult.of(this, listOf(lotto))
    }

    fun match(lottoList: List<Lotto>): LottoMatchResult {
        return LottoMatchResult.of(this, lottoList)
    }

    fun matchingNumbers(lotto: Lotto): List<Int> {
        return lottoNumbers.matchingNumbers(lotto.numbers)
    }

    fun isMatchBonusNumber(lotto: Lotto): Boolean {
        return bonusNumber in lotto.numbers.numbers
    }
}
