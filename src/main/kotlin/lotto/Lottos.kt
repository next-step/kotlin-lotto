package lotto

class Lottos(val buyLottoTicket: Int) {

    val sampleTest: List<Lotto> = (0 until buyLottoTicket)
        .map {
            Lotto().apply { generate(setOf(1, 2, 3, 4, 5, 6)) }
        }
    val purchasedLotto: List<Lotto> = (0 until buyLottoTicket)
        .map {
            Lotto()
                .apply { generate(autoLotto()) }
        }

    fun getLottoResultsWithBonus(winNumber: List<Int>, bonusNumber: Int): List<Rank> {
        return this.purchasedLotto.map({ it -> it.getPrizeWithBonus(winNumber, bonusNumber) })
    }
}
