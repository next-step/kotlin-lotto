package lotto.domain

import lotto.domain.dto.LottoNumber

class LottoStore(insertAmount: Int, manualCount: Int) {

    init {
        require(insertAmount / LOTTO_UNIT_PRICE >= manualCount) {
            "로또 구매 가능 갯수보다 수동 구매 갯수가 더 많습니다."
        }
    }

    val purchasable = insertAmount / LOTTO_UNIT_PRICE - manualCount

    fun purchase(): List<LottoNumber> {
        return List(this.purchasable) { LottoNumberGenerator.autoGenerate() }
    }

    companion object {
        private const val LOTTO_UNIT_PRICE = 1000
    }
}
