package lotto.controller

import lotto.domain.Amount
import lotto.domain.LottoNumber
import lotto.domain.LottoNumberGenerator
import lotto.domain.LottoResult
import lotto.domain.LottoShop
import lotto.domain.LottoTicket
import lotto.domain.WinningLotto
import lotto.error.CustomException

class LottoController(
    private val shop: LottoShop = LottoShop(),
    private var purchasedTicket: LottoTicket? = null,
) {
    fun purchase(request: PurchaseRequest): PurchaseResponse =
        shop.purchase(Amount(request.amount), request.manualLottoNumbers.toLottoNumbers())
            .save()
            .let(::PurchaseResponse)

    fun end(request: EndLottoRequest): EndLottoResponse {
        val purchasedTicket =
            purchasedTicket ?: return EndLottoResponse(LottoResult.withoutPurchasedTicket())
        val winningLotto = WinningLotto(
            winningNumber = LottoNumberGenerator.createFrom(request.winningNumbers),
            bonusNumber = request.bonusNumber
        )
        return shop.receivePrize(purchasedTicket, winningLotto).let(::EndLottoResponse)
    }

    private fun LottoTicket.save(): LottoTicket =
        this.also { purchasedTicket = it }

    private fun List<List<Int>>.toLottoNumbers(): List<LottoNumber> = this.map { LottoNumberGenerator.createFrom(it) }
}
