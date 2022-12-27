package lotto.domain

import lotto.common.IntegerNumberList

class LottoShop(
    private val lottoGenerator: LottoGenerator,
    private var payment: Payment
) {
    fun buyAutoLotto(): List<Lotto> {
        val totalLottoCount = calculateLottoCount(payment)
        return lottoGenerator.generate(totalLottoCount)
    }

    fun buyManualLotto(manualNumberList: List<IntegerNumberList>): List<Lotto> {
        val totalLottoCount = calculateLottoCount(payment)
        val manualLottoCount = manualNumberList.size

        require(manualLottoCount <= totalLottoCount) { "수동 로또 개수가 지불 금액보다 많아 로또를 구입할 수 없습니다." }

        val change = payment.charge(manualLottoCount * LOTTO_PRICE)
        updatePayment(change)
        return lottoGenerator.generate(manualNumberList)
    }

    private fun calculateLottoCount(payment: Payment): Int {
        return payment.amount / LOTTO_PRICE
    }

    private fun updatePayment(newPayment: Payment) {
        this.payment = newPayment
    }

    companion object {
        private const val LOTTO_PRICE = 1000
    }
}
