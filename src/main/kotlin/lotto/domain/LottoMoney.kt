package lotto.domain

class LottoMoney(val money: Int) {

    init {
        require(money >= LOTTO_COST) {
            "로또 구매 금액은 최소 ${LOTTO_COST}원 이상이어야 합니다. 현재 금액: $money"
        }
    }

    fun calculateQuantity(): Int {
        return money / LOTTO_COST
    }

    companion object {
        const val LOTTO_COST = 1000
    }
}
