package lotto.domain

import lotto.common.IntegerNumber

class LottoShop(
    private val lottoGenerator: LottoGenerator
) {
    fun buyLotto(inputPayment: Payment): List<Lotto> {
        val lottoCount = calculateLottoCount(inputPayment)
        return lottoGenerator.generate(lottoCount)
    }

    private fun calculateLottoCount(payment: Payment): IntegerNumber {
        return payment.payment.divide(LOTTO_PRICE)
    }

    companion object {
        private val LOTTO_PRICE = IntegerNumber(1000)
    }
}
