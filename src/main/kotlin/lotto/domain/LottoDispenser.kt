package lotto.domain

import lotto.domain.model.Lotto

class LottoDispenser(private val amount: Int) {

    val list: List<Lotto> = makeLottoList()

    init {
        if (amount < MINIMUM_PRICE) {
            throw IllegalArgumentException("구입 금액은 ${MINIMUM_PRICE}원 이하가 될 수 없습니다")
        }
    }

    private fun makeLottoList(): List<Lotto> {
        return List(amount / MINIMUM_PRICE) {
            Lotto()
        }
    }
}
