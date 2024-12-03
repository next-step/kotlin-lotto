package lotto

import lotto.model.Lotto
import lotto.model.LottoMatchResults
import lotto.model.LottoPurchase
import lotto.model.Lottos

class LottoAutoController {
    fun countPurchasedLotto(input: String): LottoPurchase {
        val purchaseAmount = input.convertToInt()
        val lottoCount = Lotto.count(purchaseAmount)
        return LottoPurchase(purchaseAmount, lottoCount)
    }

    fun generateLottos(lottoCount: Int): Lottos = Lottos.from(List(lottoCount) { Lotto.fromAuto() })

    fun matchLottoNumbers(
        input: String,
        lottos: Lottos,
    ): LottoMatchResults {
        val winningNumbers = input.convertToInts()
        return lottos.countMatchingLottoNumbers(Lotto.from(winningNumbers))
    }

    fun calculateReturnRate(
        lottoMatchResults: LottoMatchResults,
        purchaseAmount: Int,
    ): Double = lottoMatchResults.calculateReturnRate(purchaseAmount)

    private fun String.convertToInt(): Int = this.toIntOrNull() ?: throw RuntimeException("숫자로 입력하지 않았습니다.")

    private fun String.convertToInts(): List<Int> =
        this.split(",")
            .map { it.trim() }
            .filter { it.isNotEmpty() }
            .map {
                it.toIntOrNull() ?: throw NumberFormatException("숫자로 입력하지 않았습니다.")
            }
}
