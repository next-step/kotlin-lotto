package lotto.domain

@JvmInline
value class Lottos private constructor(
    val lottos: List<Lotto>
) {

    fun match(lotto: Lotto, bonusBall: BonusBall): LottoResult {
        val rankCounts = lottos.map { Rank.rankByMatchCount(lotto.countMatchNumber(it), it.contains(bonusBall.lottoNumber)) }
            .groupingBy { it }
            .eachCount()
        return LottoResult.of(rankCounts)
    }

    companion object {

        fun from(lottos: List<Lotto>): Lottos {
            return Lottos(lottos)
        }

        fun of(lottoGenerator: LottoGenerator, money: Money): Lottos {
            return Lottos(lottoGenerator.generateLotto(money))
        }
    }
}
