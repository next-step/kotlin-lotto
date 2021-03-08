package lotto.model

enum class Coincidence(val coincidenceCount: Int, val prizeMoney: Int) {
    THREE(3, 5_000),
    FOUR(4, 50_000),
    FIVE(5, 1_500_000),
    SIX(6, 2_000_000_000);

    fun getMatchCount(myLottos: Lottos, winningLotto: Lotto): Int {
        return myLottos.check(winningLotto, this.coincidenceCount)
    }
}
