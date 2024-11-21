package lotto.domain

class LottoMoney(private val money: Int) {

    fun calculateQuantity(): Int {
        return money / LOTTO_COST
    }

    companion object {
        const val LOTTO_COST = 1000
    }
}
