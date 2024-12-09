package lotto.domain

import lotto.stretagy.LottoNumberListGenerator

class Cashier(
    private val amount: Int,
    private val lottoNumberListGenerator: LottoNumberListGenerator,
    private val manualLotto: ManualLotto,
) {
    constructor(amount: Int, lottoNumberListGenerator: LottoNumberListGenerator) : this(
        amount,
        lottoNumberListGenerator,
        ManualLotto(emptyList()),
    )

    init {
        val availablePurchaseLottoNumber = amount / LOTTO_PRICE
        require(amount >= 1000 && availablePurchaseLottoNumber >= manualLotto.numberOfManualLottos()) {
            INVALID_MONEY
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

    companion object {
        private const val LOTTO_PRICE = 1000
        private const val INVALID_MONEY = "금액이 부족합니다."

        private fun calculateNumberOfLotto(
            amount: Int,
            numberOfManualLottos: Int,
        ): Int {
            return amount / LOTTO_PRICE - numberOfManualLottos
        }
    }
}
