package lotto.domain

class WinningLotto(
    private val lotto: Lotto,
    private val bonusNumber: LottoNumber
) {
    fun getMatchingResult(lotto: Lotto): MatchingResult {
        return MatchingResult(
            lotto.numbers.count { this.lotto.contains(it) },
            lotto.contains(bonusNumber)
        )
    }

    data class MatchingResult(
        val count: Int,
        val bonus: Boolean
    )
}
