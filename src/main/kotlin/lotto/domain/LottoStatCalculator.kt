package lotto.domain

class LottoStatCalculator(private val winningLotto: WinningLotto) {

    fun getStat(lottery: Lottery): LottoStatResult = LottoStatResult(
        lottery.groupingByRank {
            Rank.valueOf(
                compareWithWinningLotto(it),
                getIsMatchBonusNumber(it)
            )
        }.eachCount()
    )

    private fun compareWithWinningLotto(
        lotto: Lotto
    ): Int {
        return lotto.numbers.fold(0) { prev, i ->
            if (winningLotto.contains(i)) prev + 1
            else prev
        }
    }

    private fun getIsMatchBonusNumber(lotto: Lotto) = lotto.contains(winningLotto.bonusNumber)
}
