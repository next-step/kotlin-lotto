package lotto.domain

class LottoList(private val lottoList: List<LottoNumbers>, private val usedMoney: Money) {
    val size = lottoList.size
    fun match(winningNumbers: LottoNumbers, bonus: LottoNumber): LottoResult {
        val matcher = WinningMatcher(winningNumbers, bonus)

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
