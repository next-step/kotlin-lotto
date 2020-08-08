package lotto.domain

class Lottos(private val lottos: List<Lotto>) {

    fun matchResults(luckyNumbers: LuckyNumbers, bonusNumber: BonusNumber): List<Pair<Int, Boolean>> {
        return lottos.map { lotto ->
            lotto.sumOfMatchUp(luckyNumbers) to
                lotto.hasBonusNumber(bonusNumber)
        }
    }

    override fun toString(): String {
        return lottos.joinToString("\r\n")
    }
}
