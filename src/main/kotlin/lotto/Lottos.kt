package lotto

class Lottos() {

    val purchasedLotto: List<Lotto> get() = beforePurchasedLotto

    fun autoLotto(): Set<Int> {
        return (Lotto.NUMBER_MINIMUM..Lotto.NUMBER_MAXIMUM).shuffled().take(Lotto.LOTTO_NUMBER).toSortedSet()
    }

    fun addPurchasedLottoHand(number: Set<Int>) {
        beforePurchasedLotto.add(
            Lotto(number)
        )
    }

    fun addPurchasedLottoAuto() {
        beforePurchasedLotto.add(
            Lotto(autoLotto())
        )
    }

    fun getLottoResultsWithBonus(winNumber: List<Int>, bonusNumber: Int): List<Rank> {
        return this.purchasedLotto.map { it.getPrizeWithBonus(winNumber, bonusNumber) }
    }

    companion object {
        var beforePurchasedLotto = mutableListOf<Lotto>()
    }
}
