package lotto

data class Lotto(val strategy: CreateStrategy) {
    val lottoNumbers: LottoNumbers = strategy.createNumbers()
    fun getLottoResult(winningNumbers: WinningNumbers): LottoRank {
        return LottoRank.of(lottoNumbers.getContainCount(winningNumbers))
    }
}
