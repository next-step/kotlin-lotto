package lotto.domain

import lotto.domain.dto.LottoNumber

class LottoStore(insertAmount: Int) {

    val purchasable = insertAmount.div(LOTTO_UNIT_PRICE)

    fun purchase(): List<LottoNumber> {
        return List(this.purchasable) { LottoNumberGenerator.autoGenerate() }
    }

    companion object {
        private const val LOTTO_UNIT_PRICE = 1000
    }
}
