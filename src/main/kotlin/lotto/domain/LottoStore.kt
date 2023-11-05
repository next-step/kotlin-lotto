package lotto.domain

class LottoStore(private val lottoGenerator: LottoGenerator) {
    fun buyLottos(money: Int): List<Lotto> {
        val lottoCount = money / 1000

        return List(lottoCount) {
            lottoGenerator.publish()
        }
    }
}
