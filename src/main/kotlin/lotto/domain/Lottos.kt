package lotto.domain

data class Lottos(private val lottos: List<Lotto>) : List<Lotto> by lottos {
    fun groupByLottoRank(winningLotto: Lotto, bonusBall: LottoNumber): Map<LottoRank, Lottos> {
        return lottos.groupBy { lotto ->
            val matchCount = lotto.match(winningLotto)
            LottoRank.getRank(matchCount, lotto.containsBonusBall(bonusBall))
        }.mapValues { (_, lottos) -> Lottos(lottos) }
    }

    operator fun plus(other: Lottos): Lottos {
        return Lottos(this.lottos + other.lottos)
    }
}
