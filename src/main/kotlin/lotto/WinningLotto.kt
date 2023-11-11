package lotto

class WinningLotto(
    private val lotto: Lotto,
    private val bonusNumber: Int
) {

    fun judge(other: Lotto): Prize {
        val matchedCount = lotto.matchedCount(other)

        return when (matchedCount) {
            3 -> Prize.FIFTH
            4 -> Prize.FOURTH
            5 -> if (other.numbers.contains(bonusNumber)) Prize.SECOND else Prize.THIRD
            6 -> Prize.FIRST
            else -> Prize.SECOND
        }
    }
}
