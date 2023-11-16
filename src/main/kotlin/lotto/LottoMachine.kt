package lotto

import lotto.data.Lotto
import lotto.data.LottoNumber
import lotto.data.LottoRanking
import java.util.TreeSet

object LottoMachine {

    private const val SIX = 6
    private const val FIVE = 5
    private const val FOUR = 4
    private const val THREE = 3

    fun createSelectLotto(lottoNumbers: TreeSet<LottoNumber>): Lotto {
        return Lotto(lottoNumbers)
    }

    fun checkLotto(winningLotto: Lotto, purchaseLotto: Lotto): LottoRanking {
        val winningLottoToSet = winningLotto.selectNumbers.toSet()
        val purchaseLottoToSet = purchaseLotto.selectNumbers.toSet()
        val intersectNumber = winningLottoToSet.intersect(purchaseLottoToSet)

        return when (intersectNumber.size) {
            SIX -> LottoRanking.FirstPlace
            FIVE -> LottoRanking.SecondPlace
            FOUR -> LottoRanking.ThirdPlace
            THREE -> LottoRanking.FourthPlace
            else -> LottoRanking.None
        }
    }

    fun createWinningRate(cash: Int, winningStatus: Map<LottoRanking, Int>): Float {
        val totalPrice = createTotalWinningPrice(winningStatus)

        return totalPrice / cash.toFloat()
    }

    private fun createTotalWinningPrice(winningStatus: Map<LottoRanking, Int>): Int {
        var totalPrice = 0

        totalPrice += (winningStatus.getOrDefault(LottoRanking.FirstPlace, 0) * LottoRanking.FirstPlace.price)
        totalPrice += (winningStatus.getOrDefault(LottoRanking.SecondPlace, 0) * LottoRanking.SecondPlace.price)
        totalPrice += (winningStatus.getOrDefault(LottoRanking.ThirdPlace, 0) * LottoRanking.ThirdPlace.price)
        totalPrice += (winningStatus.getOrDefault(LottoRanking.FourthPlace, 0) * LottoRanking.FourthPlace.price)

        return totalPrice
    }
}
