package lotto.domain

import lotto.stretagy.LottoNumberListGenerator

class Cashier(
    private val amount: Int,
    private val lottoNumberListGenerator: LottoNumberListGenerator,
    private val manualLotto: ManualLotto = ManualLotto(emptyList()),
) {
    init {
        require(amount >= LOTTO_PRICE) {
            INSUFFICIENT_FUNDS
        }

        val availablePurchaseLottoNumber = amount / LOTTO_PRICE
        require(availablePurchaseLottoNumber >= manualLotto.numberOfManualLottos()) {
            NO_BALANCE_FOR_MANUAL_LOTTO
        }
    }

    fun purchaseAutoLottos(): LottoTicket {
        val numberOfLotto = calculateNumberOfLotto(amount, manualLotto.numberOfManualLottos())
        return LottoTicket(
            List(numberOfLotto) { Lotto(lottoNumberListGenerator.generate()) },
        )
    }

    fun purchaseManualLottos(): LottoTicket {
        val lottos = manualLotto.toLotto()
        return LottoTicket(lottos)
    }

    private fun calculateNumberOfLotto(
        amount: Int,
        numberOfManualLottos: Int,
    ): Int {
        return amount / LOTTO_PRICE - numberOfManualLottos
    }

    fun flatLottos(vararg ticket: LottoTicket): LottoTicket {
        return LottoTicket(ticket.flatMap { it.tickets })
    }

    companion object {
        private const val LOTTO_PRICE = 1000
        private const val INSUFFICIENT_FUNDS = "금액이 부족합니다."
        private const val NO_BALANCE_FOR_MANUAL_LOTTO = "수동로또를 구매할 잔액이 남지 않았습니다."
    }
}
