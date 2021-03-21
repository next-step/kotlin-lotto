package lotto.domain

class LottoGame(val lotto: List<Lotto>) {
    fun matchLotto(winningLotto: Lotto): Map<LottoRank, Int> {
        return lotto.map { LottoRank.matchRank(it.matchCount(winningLotto.lottoNumbers)) }
            .groupingBy { it }
            .eachCount()
    }
}
