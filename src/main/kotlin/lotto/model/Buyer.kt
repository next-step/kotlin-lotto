package lotto.model

class Buyer {
    var lottos = mutableListOf<Lotto>()

    fun buyLotto(money: Int): List<Lotto> {
        require(money > LOTTO_PRICE) { "돈이 부족합니다." }

        val maker = LottoMaker()
        val lottoCount = Math.floorDiv(money, LOTTO_PRICE)

        lottos = MutableList(lottoCount) { maker.make() }

        return lottos
    }

    companion object {
        private const val LOTTO_PRICE = 1000
    }
}
