package lotto

class WinningLotto(
    private val lotto: Lotto,
    private val bonusNumber: Int
) {
    fun judge(other: Lotto): Prize {
        val matchedCount = other.matchedCount(lotto)
        val hasBonusNumber = other.contains(bonusNumber)
        return Prize.find(matchedCount, hasBonusNumber)
    }
}
