package lotto.domain

data class Lottos(private val lottos: List<Lotto>) {
    val size: Int
        get() = lottos.size

    fun getLottos(): List<Lotto> = lottos

    fun groupByLottoRank(winningLotto: Lotto, bonusBall: LottoNumber): Map<LottoRank, Lottos> {
        return lottos.groupBy { lotto ->
            val matchCount = lotto.match(winningLotto)
            LottoRank.getRank(matchCount, lotto.containsBonusBall(bonusBall))
        }.mapValues { (_, lottos) -> Lottos(lottos) }
    }
}
