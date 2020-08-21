package lotto

class Lottos(val buyLottoTicket: Int) {

    val purchasedLotto: List<Lotto> = (0 until buyLottoTicket)
        .map {
            Lotto()
                .apply { generate(autoLotto()) }
        }

    fun getLottoResults(winNumber: List<Int>): List<Rank> {
        return this.purchasedLotto.map { it.getPrize(winNumber) }
    }
}
