package lotto.domain

class LottoGame {
    fun initGame(money: Long): Long {
        val numOfLotto = getNumOfLotto(money)
        return numOfLotto
    }
    private fun getNumOfLotto(money: Long): Long {
        require(money >= 1000L) { "구입가능한 로또가 없어요. 1000원 이상의 금액만 입력해주세요." }
        return money / LOTTO_PRICE
    }

    companion object {
        const val LOTTO_PRICE = 1000L
    }
}
