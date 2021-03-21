package lotto.domain

class LottoCollection(val lotto: List<Lotto>) {
    init {
        require(lotto.isNotEmpty()) { "로또는 1개 이상을 갖고있어야 합니다." }
    }

    constructor(count: Int, generator: LottoNumberGenerator = LottoNumberRandomGenerator()) : this(
        createLotto(
            count,
            generator
        )
    )

    fun matchByWonNumber(wonNumbers: LottoWonNumbers): LottoRankCollection {
        val rankCount: Map<Rank, Int> = lotto
            .map {
                it.matchByWonNumber(wonNumbers)
            }
            .groupingBy { it }
            .eachCount()

        return LottoRankCollection(rankCount)
    }

    companion object {
        private fun createLotto(count: Int, generator: LottoNumberGenerator): List<Lotto> {
            val lotto: MutableList<Lotto> = mutableListOf()

            repeat(count) {
                lotto.add(Lotto(generator))
            }

            return lotto.toList()
        }
    }
}
