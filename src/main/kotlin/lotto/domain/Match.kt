package lotto.domain

class Match(private val matchCount: Int, private val isMatchedBonusBall: Boolean) {
    fun rank(): Int {
        if (matchCount == 6) {
            return 1
        }
        if (matchCount == 5 && isMatchedBonusBall) {
            return 2
        }
        if (matchCount == 5) {
            return 3
        }
        if (matchCount == 4) {
            return 4
        }
        if (matchCount == 3) {
            return 5
        }
        return 0
    }
}
