package lotto.domain

data class LottoGameResult(val numberOfHit: Int, val bonus: Boolean = false) {
    override fun equals(other: Any?): Boolean {
        if (other !is LottoGameResult)
            return false
        val isSameHit = numberOfHit == other.numberOfHit
        if (!isSameHit)
            return false
        if (BONUS_ABLE_HIT_LIST.contains(numberOfHit))
            return other.bonus == bonus
        return true
    }

    override fun hashCode(): Int {
        var result = numberOfHit
        result = 31 * result + bonus.hashCode()
        return result
    }

    companion object {
        val BONUS_ABLE_HIT_LIST = listOf(5)
    }
}
