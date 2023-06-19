package lotto.domain

class BillSlot(private val lottoPrice: Int) {

    init {
        require(lottoPrice > 0) { "로또의 가격은 0보다 커야 합니다." }
    }

    fun insertMoney(money: Int): Int {
        return money / lottoPrice
    }
}
