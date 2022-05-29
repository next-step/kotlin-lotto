package lotto.domain

class LottoGame {
    fun getNumOfLotto(money: Long): Long {
        return money / LOTTO_PRICE
    }

    companion object {
        const val LOTTO_PRICE = 1000L
    }
}
