package lotto.domain

class BillSlot(private val lottoPrice: Int) {

    init {
        require(lottoPrice > 0)
    }

    fun insertMoney(money: Int): Int {
        return money / lottoPrice
    }
}
