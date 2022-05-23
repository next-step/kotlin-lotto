package lotto.domain

object LottoMarket {
    private const val lottoPrice = 1_000

    fun sell(price: Int): List<List<Int>> {
        return createLottos(lottoAmount(price))
    }

    fun lottoAmount(price: Int): Int {
        return price / lottoPrice
    }

    private fun createLottos(amount: Int): List<List<Int>> {
        println("${amount}개를 구매했습니다.")

        val lottos = mutableListOf<List<Int>>()
        repeat(amount) {
            lottos.add(Lotto.create())
        }

        return lottos
    }
}
