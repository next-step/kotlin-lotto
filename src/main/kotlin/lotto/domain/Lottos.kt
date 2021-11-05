package lotto.domain

data class Lottos(val lottos: List<Lotto>) {

    fun match(lotto: Lotto): Map<Rank, Int> {
        return lottos.map { Rank.rankByMatchCount(lotto.countMatchNumber(it)) }
            .groupingBy { it }
            .eachCount()
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
