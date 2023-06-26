package lotto.domain

class Lotto(
    val numbers: LottoNumbers = LottoNumbers.random(),
    val type: LottoType,
) {
    fun calculateResult(
        winningLotto: WinningLotto,
    ): LottoRank? {
        return LottoRank.of(
            matchCount = numbers.getMatchCount(winningLotto.numbers),
            isBonusNumberMatch = numbers.isContains(winningLotto.bonusNumber),
        )
    }

    companion object {
        const val PRICE = 1000
    }
}
