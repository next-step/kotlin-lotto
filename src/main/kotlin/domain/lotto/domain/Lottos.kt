package domain.lotto.domain

import domain.lotto.strategy.LottoShuffleStrategy

@JvmInline
value class Lottos private constructor(private val lottos: List<Lotto>) {

    companion object {
        private const val START = 1

        fun from(numberOfPurchase: Int, shuffleStrategy: LottoShuffleStrategy): Lottos =
            of((START..numberOfPurchase).map { Lotto.of(shuffleStrategy) }.toList())

        fun of(lottos: List<Lotto>): Lottos = Lottos(lottos.toList())
    }
}
