package lotto

class Lottos() {

    var purchasedLotto: MutableList<Lotto> = mutableListOf<Lotto>()

    fun autoLotto(): Set<Int> {
        return (Lotto.NUMBER_MINIMUM..Lotto.NUMBER_MAXIMUM).shuffled().take(Lotto.LOTTO_NUMBER).toSortedSet()
    }

    fun addPurchasedLottoHand(number: Set<Int>) {
        purchasedLotto.add(
            Lotto(number)
        )
    }

    fun addPurchasedLottoAuto() {
        purchasedLotto.add(
            Lotto(autoLotto())
        )
    }

    fun getLottoResultsWithBonus(winNumber: List<Int>, bonusNumber: Int): List<Rank> {
        return this.purchasedLotto.map { it.getPrizeWithBonus(winNumber, bonusNumber) }

    }
}
