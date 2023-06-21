package lotto.test

import lotto.Lotto
import lotto.LottoPurchaseCommand

internal class FixedLottoPurchaseCommand(
    private val lottos: List<Lotto>,
) : LottoPurchaseCommand {
    override fun fetchPurchaseLottoByCount(count: Int): List<Lotto> {
        return lottos.take(count)
    }
}
