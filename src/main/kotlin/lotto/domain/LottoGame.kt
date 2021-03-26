package lotto.domain

class LottoGame(val lotto: List<Lotto>) {
    fun matchLotto(winningLotto: WinningLotto): Map<LottoRank, Int> {
        return lotto.map {
            LottoRank.matchRank(
                it.matchCount(winningLotto.lotto.lottoNumbers),
                it.matchBonus(winningLotto.bonusNumber)
            )
        }.groupingBy { it }
            .eachCount()
    }
}
