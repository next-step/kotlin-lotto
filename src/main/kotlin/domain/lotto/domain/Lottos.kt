package domain.lotto.domain

import domain.lotto.strategy.LottoShuffleStrategy

@JvmInline
value class Lottos private constructor(private val lottos: List<Lotto>) {

    fun match(winningLotto: Lotto): Map<MatchBoard, Int> {
        val eachCount = lottos
            .groupingBy { MatchBoard.values(it.match(winningLotto)) }
            .eachCount()
        return MatchBoard.valuesExcludedMiss()
            .associateWith { eachCount[it] ?: NO_MATCH }
    }

    companion object {
        private const val NO_MATCH = 0
        private const val START = 1

        fun from(numberOfPurchase: Int, shuffleStrategy: LottoShuffleStrategy): Lottos =
            of((START..numberOfPurchase).map { Lotto.of(shuffleStrategy) }.toList())

        fun of(lottos: List<Lotto>): Lottos = Lottos(lottos.toList())
    }
}
