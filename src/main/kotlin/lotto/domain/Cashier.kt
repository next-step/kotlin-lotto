package lotto.domain

import lotto.stretagy.LottoNumberListGenerator

class Cashier(
    private val amount: Amount,
    private val lottoNumberListGenerator: LottoNumberListGenerator,
    private val manualLotto: ManualLotto = ManualLotto(emptyList()),
) {
    init {
        require(amount >= LOTTO_PRICE) {
            INSUFFICIENT_FUNDS
        }

        val availablePurchaseLottoNumber = (amount / LOTTO_PRICE)
        require(availablePurchaseLottoNumber >= Amount(manualLotto.numberOfManualLottos())) {
            NO_BALANCE_FOR_MANUAL_LOTTO
        }
    }

    fun purchaseAutoLottos(): LottoTicket {
        val numberOfLotto = calculateNumberOfLotto(amount, Amount(manualLotto.numberOfManualLottos()))
        return LottoTicket(
            List(numberOfLotto.toInt()) { Lotto(lottoNumberListGenerator.generate()) },
        )
    }

    fun purchaseManualLottos(): LottoTicket {
        val lottos =
            manualLotto.manualLottoNumbers.map {
                it.map(::LottoNumber).toSet()
            }.map { Lotto(it) }

        return LottoTicket(lottos)
    }

    private fun calculateNumberOfLotto(
        amount: Amount,
        numberOfManualLottos: Amount,
    ): Amount {
        return (amount / LOTTO_PRICE) - numberOfManualLottos
    }

    companion object {
        private val LOTTO_PRICE = Amount(1000)
        private const val INSUFFICIENT_FUNDS = "금액이 부족합니다."
        private const val NO_BALANCE_FOR_MANUAL_LOTTO = "수동로또를 구매할 잔액이 남지 않았습니다."
    }
}
