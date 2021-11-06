package lotto.domain

data class LottoGameResult(val numberOfHit: Int, val bonus: Boolean = false) {
    override fun equals(other: Any?): Boolean {
        if (other !is LottoGameResult)
            return false
        if (numberOfHit != other.numberOfHit)
            return false
        if (bonus || other.bonus)
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
        var result = numberOfHit
        result = 31 * result + bonus.hashCode()
        return result
    }
}
