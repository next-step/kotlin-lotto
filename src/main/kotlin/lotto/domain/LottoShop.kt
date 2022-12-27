package lotto.domain

import lotto.common.IntegerNumberList

class LottoShop(
    private val lottoGenerator: LottoGenerator
) {
    fun buyAutoLotto(payment: Payment): List<Lotto> {
        val totalLottoCount = calculateLottoCount(payment)
        return lottoGenerator.generate(totalLottoCount)
    }

    fun buyManualLotto(payment: Payment, manualNumberList: List<IntegerNumberList>): List<Lotto> {
        val totalLottoCount = calculateLottoCount(payment)
        val manualLottoCount = manualNumberList.size

        require(manualLottoCount <= totalLottoCount) { "수동 로또 개수가 지불 금액보다 많아 로또를 구입할 수 없습니다." }

        payment.charge(manualLottoCount * LOTTO_PRICE)
        return lottoGenerator.generate(manualNumberList)
    }

    private fun calculateLottoCount(payment: Payment): Int {
        return payment.payment / LOTTO_PRICE
    }

    companion object {
        private val LOTTO_PRICE = 1000
    }
}
