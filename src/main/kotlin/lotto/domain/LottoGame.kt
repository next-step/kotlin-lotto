package lotto.domain

import java.math.BigInteger

class LottoGame(private val lottos: List<Lotto>, private val winningLotto: Lotto) {

    private val prize: BigInteger =
        MATCH3_PRIZE.toBigInteger().multiply(match(3).toBigInteger()) + MATCH4_PRIZE.toBigInteger()
            .multiply(match(4).toBigInteger()) + MATCH5_PRIZE.toBigInteger()
            .multiply(match(5).toBigInteger()) + MATCH6_PRIZE.toBigInteger().multiply(match(6).toBigInteger())

    val profit: Double = prize.toDouble() / (lottos.size * LOTTO_PRICE)

    fun match(i: Int): Int {
        return lottos.filter { lotto ->
            lotto.match(winningLotto) == i
        }.size
    }

    companion object {
        private const val LOTTO_PRICE = 1_000
        private const val MATCH3_PRIZE = 5_000
        private const val MATCH4_PRIZE = 50_000
        private const val MATCH5_PRIZE = 1_500_000
        private const val MATCH6_PRIZE = 2_000_000_000
    }
}
