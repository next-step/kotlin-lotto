package lotto.service

import lotto.domain.Lotto
import lotto.domain.LottoGenerator
import lotto.domain.LottoPurchaseCount
import lotto.domain.LottoResults

class LottoService(
    private val lottoGenerator: LottoGenerator,
) {
    fun buy(count: LottoPurchaseCount): List<Lotto> {
        return List(count.amount) { lottoGenerator.generate(Lotto.LOTTO_SIZE) }
    }

    fun getResults(
        lottos: List<Lotto>,
        winningNumbers: Lotto,
    ): LottoResults {
        val winInfo = lottos.map { it.match(winningNumbers) }.groupingBy { it }.eachCount()
        return LottoResults.from(winInfo)
    }

    private fun getAvailableLottoCount(payAmount: Int): Int = payAmount / LottoPurchaseCount.PRICE_PER_LOTTO
}
