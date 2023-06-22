package next.step.lotto.domain

data class WinningLotto(val winningNumbers: Set<LottoNumber>, val bonusNumber: LottoNumber) {

    fun match(lottos: Lottos): LottoWinningStat = LottoWinningStat.of(lottoWinningStat(lottos))

    private fun lottoWinningStat(lottos: Lottos) = lottos.lottos.groupingBy { lottoRank(it) }.eachCount()

    private fun lottoRank(lotto: Lotto) = LottoRank.from(matchNumbers(lotto), matchNumber(lotto))

    private fun matchNumbers(lotto: Lotto) = lotto.match(winningNumbers)

    private fun matchNumber(lotto: Lotto) = lotto.match(bonusNumber)

    companion object {
        fun of(winningNumbers: Set<LottoNumber>, bonusNumber: LottoNumber): WinningLotto =
            WinningLotto(winningNumbers, bonusNumber)
    }
}