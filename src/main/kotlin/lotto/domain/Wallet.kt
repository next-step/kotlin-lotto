package lotto.domain

class Wallet(private var money: Int) {
    fun buyManualLotto(size: Int) {
        money -= Lotto.PRICE * size
    }

    fun getLeftMoney(): Int = money
}
