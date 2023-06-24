package lotto.domain

class WinningLotto(
    val numbers: LottoNumbers = LottoNumbers.random(),
    val bonusNumber: LottoNumber = LottoNumber.random(),
) {
    fun match(lotto: Lotto): LottoRank? {
        return LottoRank.of(
            matchCount = lotto.numbers.getMatchCount(numbers),
            isBonusNumberMatch = lotto.numbers.isContains(bonusNumber),
        )
    }
}
