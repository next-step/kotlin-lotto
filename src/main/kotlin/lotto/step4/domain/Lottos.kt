package lotto.step4.domain

class Lottos(
    private val lottos: List<Lotto>,
) {
    fun size(): Int = lottos.size

    fun getAll(): List<Lotto> = lottos

    fun add(other: Lottos): Lottos {
        return Lottos(this.lottos + other.lottos)
    }

    fun matchWinningNumbers(
        winningNumbers: Set<LottoNumber>,
        bonusNumber: LottoNumber,
    ): Ranks {
        return lottos.groupBy { lotto ->
            val matchCount = lotto.numbers.intersect(winningNumbers).size
            val hasBonusNumber = lotto.numbers.contains(bonusNumber)
            Rank.valueOf(matchCount, hasBonusNumber)
        }.mapValues { it.value.size.toLong() }
            .let { Ranks(it) }
    }
}
