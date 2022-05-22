package lotto.domin

import lotto.util.LottoNumberGenerator

class Lotto(
    private val payment: Int,
    private val lottoNumberGenerator: LottoNumberGenerator
) {

    fun issuanceCount(): Int {
        return payment.div(LOTTO_PRICE)
    }

    fun issuance(): List<Int> {
        return this.lottoNumberGenerator.numberSet()
    }

    companion object {
        const val LOTTO_PRICE = 1_000
    }
}
