package lotto

class WinningLotto(
    private val lotto: Lotto,
    private val bonusNumber: Int
) {
    fun judge(other: Lotto): Rank {
        val matchedCount = other.matchedCount(lotto)
        val hasBonusNumber = other.contains(bonusNumber)
        return Rank.find(matchedCount, hasBonusNumber)
    }
}
