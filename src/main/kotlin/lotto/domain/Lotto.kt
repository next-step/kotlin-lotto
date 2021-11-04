package lotto.domain

class Lotto(
    val numbers: LottoNumbers,
    val price: Int,
) {
    fun sortilege(
        winningNumber: WinningNumber,
    ): Rank {
        val matchCount = numbers.getMatchCount(winningNumber.numbers)
        val isMatchedBonusNumber = numbers.isMatchedBonusNumber(winningNumber.bonusNumber)

        return Rank.findBy(matchCount, isMatchedBonusNumber)
    }

    override fun toString(): String {
        return "$numbers"
    }
}
