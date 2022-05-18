package lotto.domain

class WinningLotto(numbers: List<Int>) : Lotto(numbers) {
    fun match(lottoList: List<Lotto>): LottoMatchResult {
        return LottoMatchResult(this, lottoList)
    }
}
