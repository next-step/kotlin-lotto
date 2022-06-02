package lotto.domain

class LottoList(private val lottoList: List<LottoNumbers>, private val usedMoney: Money) {
    val size = lottoList.size
    fun match(winningNumbers: LottoNumbers): LottoResult {
        val matcher = WinningMatcher(winningNumbers)

        return LottoResult(
            usedMoney,
            lottoList.map {
                matcher.getMatchGrade(it)
            }
        )
    }

    fun forEach(action: (LottoNumbers) -> Unit) {
        lottoList.forEach(action)
    }
}
