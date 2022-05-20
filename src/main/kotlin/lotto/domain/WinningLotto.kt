package lotto.domain

class WinningLotto(private val lottoNumbers: LottoNumbers) {
    constructor(numbers: List<Int>) : this(LottoNumbers(numbers))

    fun match(lottoList: List<Lotto>): LottoMatchResult {
        return LottoMatchResult.of(this, lottoList)
    }

    fun matchingNumbers(lotto: Lotto): List<Int> {
        return lottoNumbers.matchingNumbers(lotto.numbers)
    }
}
