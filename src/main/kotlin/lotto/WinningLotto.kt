package lotto

class WinningLotto(val lotto: Lotto, bonusNumber: Int) {

    fun judge(other: Lotto): Prize {
        val matchedCount = lotto.matchedCount(other)

        return when (matchedCount) {
            3 -> Prize.FIFTH
            4 -> Prize.FOURTH
            else -> Prize.SECOND
        }
    }
}
