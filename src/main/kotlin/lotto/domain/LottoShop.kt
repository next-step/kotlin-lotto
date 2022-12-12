package lotto.domain

import lotto.application.common.Number

class LottoShop(
    private val lottoGenerator: LottoGenerator
) {
    fun buyLotto(inputPayment: Payment): List<Lotto> {
        val lottoCount = calculateLottoCount(inputPayment)
        return lottoGenerator.generate(lottoCount)
    }

    private fun calculateLottoCount(payment: Payment): Number {
        return Number(payment.payment.number / LOTTO_PRICE)
    }

    companion object {
        private const val LOTTO_PRICE = 1000
    }
}
