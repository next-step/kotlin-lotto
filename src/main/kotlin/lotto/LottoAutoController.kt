package lotto

import lotto.model.Lotto
import lotto.model.LottoPurchase
import lotto.model.LottoSystem
import lotto.util.StringParser

class LottoAutoController {
    private val lottoSystem = LottoSystem()

    fun countPurchasedLotto(input: String): LottoPurchase {
        val purchaseAmount = StringParser.convertToInt(input)
        if (purchaseAmount <= 0) throw RuntimeException("금액은 양수입니다.")
        val lottoCount = lottoSystem.calculateLottoCount(purchaseAmount = purchaseAmount)
        return LottoPurchase(purchaseAmount, lottoCount)
    }

    fun generateLottos(lottoCount: Int): List<Lotto> = List(lottoCount) { Lotto() }

    fun matchLottoNumbers(
        input: String,
        lottos: List<Lotto>,
    ): Map<Int, Int> {
        val winningNumbers = StringParser.convertToInts(input)
        val matchedLottoNumberCounts = lottoSystem.countLottosByMatchingNumbers(winningNumbers, lottos)
        return matchedLottoNumberCounts
    }

    fun calculateReturnRate(
        matchedLottoNumberCounts: Map<Int, Int>,
        purchaseAmount: Int,
    ): Double =
        lottoSystem.calculateReturnRate(
            matchedLottoNumberCounts,
            purchaseAmount,
        )
}
