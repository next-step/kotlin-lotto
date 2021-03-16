package lotto.domain

class LottoCollection(private val _lotto: MutableList<Lotto>) {
    val lotto: List<Lotto>
        get() = _lotto

    constructor(count: Int, _generator: LottoNumberGenerator = LottoNumberRandomGenerator()) : this(mutableListOf()) {
        require(count >= 1)

        repeat(count) {
            _lotto.add(Lotto(_generator))
        }
    }

    fun matchByWonNumber(wonNumber: List<LottoNumber>): LottoRankCollection {
        val rankCount: Map<Rank, Int> = _lotto
            .map {
                it.matchByWonNumber(wonNumber)
            }
            .groupingBy { it }
            .eachCount()

        return LottoRankCollection(rankCount)
    }
}
