package lotto.domain

class Tickets(lottoCount: Int, manualLotto: List<Lotto>, private val numCreator: LottoNumGenerator) {

    val tickets: List<Lotto>

    init {
        val autoLottos = List(lottoCount - manualLotto.size) { Lotto(getLottoNumber()) }
        tickets = manualLotto + autoLottos
    }

    private fun getLottoNumber(): List<LottoNumber> {
        return numCreator.getNums()
    }
}
