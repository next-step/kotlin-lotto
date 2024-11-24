package lotto.domain

import lotto.domain.enums.LottoCompensationStrategy
import java.math.BigDecimal

class LottoUser(
    val lottoPurchaseAmount: LottoPurchaseAmount,
    lottoCount: Int = lottoPurchaseAmount.calculateLottoCount(),
    lottoGenerateStrategy: (() -> Set<Int>)? = null,
) {
    val lotteries: List<Lotto> = generateLotteries(lottoCount, lottoGenerateStrategy)

    val compensation: Long
        get() = lotteries.sumOf { it.compensation }
    val 수익률: BigDecimal
        get() = BigDecimal(compensation) / BigDecimal(lottoPurchaseAmount.amount)

    fun checkLotteries(correctNumbers: CorrectNumbers) {
        lotteries.forEach { lotto ->
            val lottoNumbers = lotto.values
            val correctCount = lottoNumbers.intersect(correctNumbers.values).size

            lotto.markCorrectCount(correctCount)
        }
    }

    fun calculateLottoCorrectCount(): Map<LottoCompensationStrategy, Int> {
        return LottoCompensationStrategy.entries.associateWith { strategy ->
            lotteries.count { it.markedCorrectCount == strategy.correctCount }
        }
    }

    companion object {
        private fun generateLotteries(lottoCount: Int, lottoGenerateStrategy: (() -> Set<Int>)?) = List(lottoCount) {
            lottoGenerateStrategy?.let { Lotto { it.invoke() } } ?: Lotto()
        }
    }
}
