package lotto.domain

import lotto.common.IntegerNumber
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
        val manualLottoCount = IntegerNumber(manualNumberList.size)

        require(manualLottoCount.number <= totalLottoCount.number) { "수동 로또 개수가 지불 금액보다 많아 로또를 구입할 수 없습니다." }

        payment.charge(manualLottoCount.multiply(LOTTO_PRICE))
        return lottoGenerator.generate(manualNumberList)
    }

    private fun calculateLottoCount(payment: Payment): IntegerNumber {
        return payment.payment.divide(LOTTO_PRICE)
    }

    companion object {
        private val LOTTO_PRICE = IntegerNumber(1000)
    }
}
