package lotto.domain

class LottoStatCalculator(private val winningLotto: WinningLotto) {

    fun getStat(lottoList: List<Lotto>): LottoStatResult {
        val result = LottoStatResult().apply {
            lottoList.forEach {
                this.addCount(Rank.valueOf(compareWithWinningLotto(it), getIsMatchBonusNumber(it)))
            }
        }

        return result
    }

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
