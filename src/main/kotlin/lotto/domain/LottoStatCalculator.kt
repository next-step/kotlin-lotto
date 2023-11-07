package lotto.domain

class LottoStatCalculator(private val winningLotto: WinningLotto) {

    fun getStat(lottoList: List<Lotto>): LottoStatResult {

        return lottoList.fold(
            LottoStatResult(
                firstCount = 0,
                secondCount = 0,
                thirdCount = 0,
                fourthCount = 0,
                fifthCount = 0,
                purchaseAmount = lottoList.count() * LottoMachine.LOTTO_PRICE
            )
        ) { prev, lotto ->
            when (compareWithWinningLotto(lotto)) {
                3 -> prev.copy(fifthCount = prev.fifthCount + 1)
                4 -> prev.copy(fourthCount = prev.fourthCount + 1)
                5 -> if (getIsMatchBonusNumber(lotto)) prev.copy(secondCount = prev.secondCount + 1)
                else prev.copy(thirdCount = prev.thirdCount + 1)
                6 -> prev.copy(firstCount = prev.firstCount + 1)

                else -> prev
            }
        }
    }

    private fun compareWithWinningLotto(
        lotto: Lotto
    ): Int {
        return lotto.numbers.fold(0) { prev, i ->
            if (winningLotto.lotto.numbers.contains(i)) prev + 1
            else prev
        }
    }

    private fun getIsMatchBonusNumber(lotto: Lotto) = lotto.numbers.contains(winningLotto.bonusNumber)
}
