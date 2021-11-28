package lotto.domain

class LottoGame(private val money: Int) {
    val count = money / PRICE

    companion object {
        const val PRICE = 1000
    }
}
