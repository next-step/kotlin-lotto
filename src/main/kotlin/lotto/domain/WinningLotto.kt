package lotto.domain

class WinningLotto(numbers: List<Int>) {

    private val numbers: LottoNumbers = LottoNumbers(numbers)

    fun match(lottoList: List<Lotto>): LottoMatchResult {
        return LottoMatchResult.of(this, lottoList)
    }

    fun matchingNumbers(lotto: Lotto): List<Int> {
        return numbers.matchingNumbers(lotto.numbers)
    }
}
