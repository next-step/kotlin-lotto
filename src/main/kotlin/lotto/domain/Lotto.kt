package lotto.domain

data class Lotto(val strategy: CreateStrategy) {
    constructor(lottoNumbers: LottoNumbers) : this(object : CreateStrategy {
        override fun createNumbers(): LottoNumbers {
            return lottoNumbers
        }
    })

    val lottoNumbers: LottoNumbers = strategy.createNumbers()
    fun getLottoResult(winningNumbers: WinningNumbers): LottoRank {
        return LottoRank.of(lottoNumbers.getContainCount(winningNumbers), lottoNumbers.isMatchBonus(winningNumbers))
    }
}
