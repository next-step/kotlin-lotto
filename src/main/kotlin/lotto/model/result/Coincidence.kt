package lotto.model.result

import lotto.model.game.WinningLotto
import lotto.model.game.Lotto
import lotto.model.game.Lottos

enum class Coincidence(val coincidenceCount: Int, val prizeMoney: Int, val hasBonusNum: Boolean) {
    FIRST(6, 2_000_000_000, false),
    SECOND(5, 30_000_000, true),
    THIRD(5, 1_500_000, false),
    FOURTH(4, 50_000, false),
    FIFTH(3, 5_000, false),
    MISS(prizeMoney = 0);

    constructor(prizeMoney: Int)

    fun getMatchedCount(lottos: Lottos, winningLotto: WinningLotto): Int {
        return lottos.getCoincidenceCount(this, winningLotto)
    }

    companion object {
        private const val TWO = 2

        fun match(myLotto: Lotto, winningLotto: WinningLotto): Coincidence {
            return findMatchedResult(myLotto, winningLotto) ?: MISS
        }

        private fun findMatchedResult(myLotto: Lotto, winningLotto: WinningLotto): Coincidence? {
            val matchedResult = values()
                .filter { it.coincidenceCount == myLotto.getMatchCount(winningLotto.winningLotto) }

            if (matchedResult.size == TWO) {
                return matchedResult.firstOrNull { it.hasBonusNum == myLotto.hasNumber(winningLotto.bonusNumber) }
            }

            return matchedResult.firstOrNull()
        }
    }
}
