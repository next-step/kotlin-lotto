package lotto.domain

class Wallet(private var money: Int) {
    fun buyLotto(size: Int) {
        money -= Lotto.PRICE * size
    }

    fun getLeftMoney(): Int = money
}
