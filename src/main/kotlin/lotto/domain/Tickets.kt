package lotto.domain

class Tickets(lottoCount: Int, private val numCreator: LottoNumGenerator) {

    val tickets = List(lottoCount) { Lotto(getLottoNumber()) }

    private fun getLottoNumber(): List<Int> {
        return numCreator.getNums()
    }
}
