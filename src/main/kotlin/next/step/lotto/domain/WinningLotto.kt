package next.step.lotto.domain

data class WinningLotto(val winningNumbers: Set<LottoNumber>, val bonusNumber: LottoNumber) {
    
    fun match(lottos: Lottos): LottoWinningStat =
        LottoWinningStat.of(lottos.lottos.groupingBy { LottoRank.from(it.match(winningNumbers), it.match(bonusNumber)) }
            .eachCount())

    companion object {
        fun of(winningNumbers: Set<LottoNumber>, bonusNumber: LottoNumber): WinningLotto =
            WinningLotto(winningNumbers, bonusNumber)
    }
}