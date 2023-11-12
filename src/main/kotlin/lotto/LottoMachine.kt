package lotto

object LottoMachine {
    private const val SIX = 6
    private const val FIVE = 5
    private const val FOUR = 4
    private const val THREE = 3

    fun createLotto(numberList: List<Int>): Lotto {
        return Lotto(numberList)
    }

    fun checkLotto(winningLotto: Lotto, purchaseLotto: Lotto): LottoRanking {
        val winningLottoToSet = winningLotto.selectNumberList.toSet()
        val purchaseLottoToSet = purchaseLotto.selectNumberList.toSet()
        val intersectNumber = winningLottoToSet.intersect(purchaseLottoToSet)

        return when (intersectNumber.size) {
            SIX -> LottoRanking.FirstPlace
            FIVE -> LottoRanking.SecondPlace
            FOUR -> LottoRanking.ThirdPlace
            THREE -> LottoRanking.FourthPlace
            else -> LottoRanking.None
        }
    }

    fun createRateOfReturn(cash: Int, winningStatus: Map<LottoRanking, Int>): Float {
        val totalWinningPrice = 0.1f
        return 0.4f
    }

    fun createTotalWinningPrice(winningStatus: Map<LottoRanking, Int>): Int {
        var totalPrice = 0

        totalPrice += (winningStatus.getOrDefault(LottoRanking.FirstPlace, 0) * LottoRanking.FirstPlace.price)
        totalPrice += (winningStatus.getOrDefault(LottoRanking.SecondPlace, 0) * LottoRanking.SecondPlace.price)
        totalPrice += (winningStatus.getOrDefault(LottoRanking.ThirdPlace, 0) * LottoRanking.ThirdPlace.price)
        totalPrice += (winningStatus.getOrDefault(LottoRanking.FourthPlace, 0) * LottoRanking.FourthPlace.price)

        return totalPrice
    }
}
