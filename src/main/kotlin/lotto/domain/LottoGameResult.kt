package lotto.domain

data class LottoGameResult(val numberOfHit: LottoHit, val bonus: BonusAble = BonusAble(false)) {
    override fun equals(other: Any?): Boolean {
        if (other !is LottoGameResult)
            return false
        if (numberOfHit != other.numberOfHit)
            return false
        if (bonus.able || other.bonus.able)
            return checkResultByTypes(other)
        return true
    }

    private fun checkResultByTypes(other: LottoGameResult): Boolean {
        val typesByHits = LotteryWinningTypes.findTypesByHits(numberOfHit)
        if (typesByHits.size == 1)
            return true
        return bonus == other.bonus
    }

    override fun hashCode(): Int {
        var result = numberOfHit.hashCode()
        result = 31 * result + bonus.hashCode()
        return result
    }
}
