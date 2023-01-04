package lotto.domain

data class Score(val matchedCount: Int, val matchedBonus: Boolean) {
    fun isMatchFiveWithBonus() = (matchedCount == 5 && matchedBonus)
}
