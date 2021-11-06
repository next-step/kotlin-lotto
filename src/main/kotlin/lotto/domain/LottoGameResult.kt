package lotto.domain

data class LottoGameResult(val numberOfHit: Int, val bonus: Boolean = false) {
    override fun equals(other: Any?): Boolean {
        if (other !is LottoGameResult)
            return false
        val isSameHit = numberOfHit == other.numberOfHit
        if (this.bonus)
            return isSameHit && other.bonus
        if (other.bonus)
            return isSameHit && bonus
        return isSameHit
    }

    override fun hashCode(): Int {
        var result = numberOfHit
        result = 31 * result + bonus.hashCode()
        return result
    }
}
