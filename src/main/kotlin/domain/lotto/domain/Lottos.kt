package domain.lotto.domain

import domain.lotto.strategy.LottoShuffleStrategy

@JvmInline
value class Lottos private constructor(val lottos: List<Lotto>) {
    fun match(winningLotto: WinningLotto): Map<MatchBoard, Int> {
        val eachCount = lottos
            .groupingBy { MatchBoard.values(winningLotto.match(it), winningLotto.isMatchBonusBall(it)) }
            .eachCount()
        return MatchBoard.valuesExcludedMiss()
            .associateWith { eachCount[it] ?: NO_MATCH }
    }

    operator fun plus(secondLottos: Lottos): Lottos = of(lottos + secondLottos.lottos)

    companion object {
        private const val NO_MATCH = 0
        private const val START = 1

        fun from(numberOfPurchase: Int, shuffleStrategy: LottoShuffleStrategy): Lottos =
            of((START..numberOfPurchase).map { Lotto.of(shuffleStrategy) }.toList())

        fun of(lottos: List<Lotto>): Lottos = Lottos(lottos.toList())

        fun empty(): Lottos = of(listOf())
    }
}
