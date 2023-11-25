package lotto.controller

import lotto.domain.Amount
import lotto.domain.LottoNumber
import lotto.domain.LottoResult
import lotto.domain.LottoShop
import lotto.domain.LottoTicket
import lotto.domain.WinningLotto
import lotto.view.InputView

class LottoController(
    private val shop: LottoShop = LottoShop(),
    private var purchasedTicket: LottoTicket? = null,
) {
    fun purchase(): LottoTicket {
        val amount = InputView.purchaseAmount.let(::Amount)
        val purchaseAmount = shop.toLottoPurchaseAmount(amount)
        val lottoNumbers = InputView.manualLottoNumbers.toLottoNumbers()
        return shop.purchase(purchaseAmount, lottoNumbers)
            .save()
    }

    fun end(): LottoResult {
        val purchasedTicket =
            purchasedTicket ?: return LottoResult.withoutPurchasedTicket()
        val winningLotto = WinningLotto(
            winningNumber = LottoNumber.of(InputView.winningNumbers),
            bonusNumber = InputView.bonusNumber
        )
        return shop.receivePrize(purchasedTicket, winningLotto)
    }

    private fun LottoTicket.save(): LottoTicket =
        this.also { purchasedTicket = it }

    private fun List<List<Int>>.toLottoNumbers(): List<LottoNumber> = this.map { LottoNumber.of(it) }
}
