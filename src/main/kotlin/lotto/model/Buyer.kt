package lotto.model

class Buyer {
    var lottoCount = 0
    var myLottos = mutableListOf<Lotto>()

    fun buyLotto(money: Int): List<Lotto> {
        require(money > LOTTO_PRICE) { "돈이 부족합니다." }

        lottoCount = Math.floorDiv(money, LOTTO_PRICE)
        myLottos = MutableList(lottoCount) { Lotto(mutableListOf()) }

        return myLottos
    }

    companion object {
        private const val LOTTO_PRICE = 1000
    }
}
