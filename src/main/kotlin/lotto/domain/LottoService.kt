package lotto.domain

import lotto.domain.strategy.RandomNumberGenerator
import java.math.RoundingMode

class LottoService(
    private val principal: Int,
    val lotteries: List<Lotto>,
) {
    val lottoCount = lotteries.size

    fun play(answer: LottoAnswer, earningStrategy: Map<MatchCount, Int>): LottoResult {
        val result = answer.match(lotteries)
        val earning = Earning(earningStrategy).calculate(result)
        val earningRate = EarningRate { earningRate ->
            val decimal = earningRate.toBigDecimal()
            decimal.setScale(2, RoundingMode.DOWN)
        }.calculate(principal, earning)
        return LottoResult(earningRate, result)
    }

    companion object {
        private const val LOTTO_PRICE: Int = 1000
        fun of(principal: Int): LottoService {
            val count = principal / LOTTO_PRICE
            return LottoService(
                principal,
                (1..count).map { Lotto.create(RandomNumberGenerator) }
            )
        }
    }
}
