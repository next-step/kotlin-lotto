package lotto.domain

data class Lottos(val lottos: List<Lotto>) {

    fun match(lotto: Lotto): LottoResult {
        val rankCounts = lottos.map { Rank.rankByMatchCount(lotto.countMatchNumber(it)) }
            .groupingBy { it }
            .eachCount()
        return LottoResult(rankCounts)
    }

    companion object {
        fun of(lottoNumberGenerator: LottoNumberGenerator, money: Money): Lottos {
            val lottoList = (0 until money.lottoCount).map {
                lottoNumberGenerator.generateLottoNumber()
            }.map { Lotto.of(it) }
            return Lottos(lottoList)
        }
    }
}
