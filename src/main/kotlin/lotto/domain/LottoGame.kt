package lotto.domain

class LottoGame {
    fun generateLotto(money: Long): List<Lotto> {
        val numOfLotto = getNumOfLotto(money)
        var lottos = emptyList<Lotto>()
        repeat(numOfLotto) {
            lottos = lottos.plus(Lotto())
        }
        return lottos
    }

    private fun getNumOfLotto(money: Long): Int {
        require(money >= 1000L) { "구입가능한 로또가 없어요. 1000원 이상의 금액만 입력해주세요." }
        require(money % LOTTO_PRICE == 0L) { "1000원 단위로 입력해주세요." }
        return (money / LOTTO_PRICE).toInt()
    }

    companion object {
        const val LOTTO_PRICE = 1000L
    }
}
