package lotto.domain

class LottoStatCalculator(private val winningLotto: WinningLotto) {

    fun getStat(lottery: Lottery): LottoStatResult = LottoStatResult(
        lottery.groupingByRank {
            Rank.valueOf(
                winningLotto.getCountOfMatch(it),
                getIsMatchBonusNumber(it)
            )
        }.eachCount()
    )

    private fun getIsMatchBonusNumber(lotto: Lotto) = lotto.contains(winningLotto.bonusNumber)
}
