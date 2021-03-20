package lotto.domain

class LottoCollection(private val _lotto: MutableList<Lotto>) {
    val lotto: List<Lotto>
        get() = _lotto

    constructor(count: Int, generator: LottoNumberGenerator = LottoNumberRandomGenerator()) : this(mutableListOf()) {
        require(count >= 1)

        repeat(count) {
            _lotto.add(Lotto(generator))
        }
    }

    fun matchByWonNumber(wonNumbers: LottoWonNumbers): LottoRankCollection {
        val rankCount: Map<Rank, Int> = _lotto
            .map {
                it.matchByWonNumber(wonNumbers)
            }
            .groupingBy { it }
            .eachCount()

        return LottoRankCollection(rankCount)
    }
}
