package lotto.domain

class WinningLotto(
    val numbers: LottoNumbers,
    val bonusNumber: LottoNumber,
) {
    fun match(lotto: Lotto): LottoRank? {
        return LottoRank.of(
            matchCount = lotto.numbers.getMatchCount(numbers),
            isBonusNumberMatch = lotto.numbers.isContains(bonusNumber),
        )
    }
}
