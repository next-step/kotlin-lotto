package lottogame.domain.rank

class RankCondition(val count: Int, private val bonusCondition: BonusCondition) {
    fun match(countOfMatch: Int, bonusMatched: Boolean): Boolean {
        return count == countOfMatch && bonusCondition.match(bonusMatched)
    }
}
