package lotto.dto

import lotto.domain.LottoNumbers.Companion.LOTTO_PRICE

class Money(money: Int) {

    private val initialMoney = money
    private var remainMoney = money

    init {
        require(money >= 0) { "로또 구입 금액은 0원 이상이어야 합니다." }
    }

    fun buyLottos(count: Int) {
        require(count >= 0) { "로또 구입 숫자는 0원 이상이어야 합니다." }
        val price = count * LOTTO_PRICE
        require(remainMoney >= price) { "로또 구입 금액은 로또 가격보다 크거나 같아야 합니다." }
        remainMoney -= price
    }

    fun buyAllLottos(): Int {
        val avail = remainMoney / LOTTO_PRICE
        remainMoney -= avail * LOTTO_PRICE
        return avail
    }

    fun getROR(price: Int) = price.toDouble() / initialMoney.toDouble()
}
