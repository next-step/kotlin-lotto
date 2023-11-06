package lotto

class LottoStatCalculator(private val winningLotto: Lotto) {

    fun getStat(lottos: List<Lotto>): LottoStatResult {

        return lottos.fold(
            LottoStatResult(
                firstCount = 0,
                thirdCount = 0,
                fourthCount = 0,
                fifthCount = 0,
                purchaseAmount = lottos.count() * LottoMachine.LOTTO_PRICE
            )
        ) { prev, lotto ->
            when (compareWithWinningLotto(lotto)) {
                3 -> prev.copy(fifthCount = prev.fifthCount + 1)
                4 -> prev.copy(fourthCount = prev.fourthCount + 1)
                5 -> prev.copy(thirdCount = prev.thirdCount + 1)
                6 -> prev.copy(firstCount = prev.firstCount + 1)
                else -> prev
            }
        }
    }

    private fun compareWithWinningLotto(
        lotto: Lotto
    ): Int {
        return lotto.numbers.fold(0) { prev, i ->
            if (winningLotto.numbers.contains(i)) prev + 1
            else prev
        }
    }

    companion object {
        const val FIRST_PLACE_REWARD = 2000000000
        const val THIRD_PLACE_REWARD = 1500000
        const val FOURTH_PLACE_REWARD = 50000
        const val FIFTH_PLACE_REWARD = 5000
    }
}
