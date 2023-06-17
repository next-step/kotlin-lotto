package lotto.domain

class BillSlot(private val lottoPrice: Int) {

    init {
        require(lottoPrice > 0) { "0보다 큰 금액을 투입해야 합니다." }
    }

    fun insertMoney(money: Int): Int {
        return money / lottoPrice
    }
}
