package lotto.model

enum class Coincidence(val coincidenceCount: Int, val prizeMoney: Int, val hasBonusNum: Boolean) {
    FIRST(6, 2_000_000_000, false),
    SECOND(5, 30_000_000, true),
    THIRD(5, 1_500_000, false),
    FOURTH(4, 50_000, false),
    FIFTH(3, 5_000, false),
    MISS(prizeMoney = 0);

    constructor(prizeMoney: Int)

    companion object {
        fun match(myLotto: Lotto, winningLotto: WinningLotto): Coincidence {
            return findMatchedResult(myLotto, winningLotto) ?: MISS
        }

        private fun findMatchedResult(myLotto: Lotto, winningLotto: WinningLotto): Coincidence? {
            return values()
                .filter { it.coincidenceCount == myLotto.getMatchCount(winningLotto.winningLotto) }
                .firstOrNull { it.hasBonusNum == myLotto.hasNumber(winningLotto.bonusNumber) }
        }
    }
}
