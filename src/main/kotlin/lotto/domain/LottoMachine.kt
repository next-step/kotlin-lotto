package lotto.domain

import lotto.data.Lotto
import lotto.data.LottoNumber
import lotto.data.LottoRanking
import lotto.data.LottoRanking.FirstPlace
import lotto.data.LottoRanking.FourthPlace
import lotto.data.LottoRanking.None
import lotto.data.LottoRanking.SecondPlace
import lotto.data.LottoRanking.ThirdPlace

object LottoMachine {

    fun createSelectLotto(lottoNumbers: LinkedHashSet<LottoNumber>): Lotto {
        return Lotto(lottoNumbers)
    }

    fun checkLotto(winningLotto: Lotto, purchaseLotto: Lotto): LottoRanking {
        val winningLottoToSet = winningLotto.selectNumbers.toSet()
        val purchaseLottoToSet = purchaseLotto.selectNumbers.toSet()
        val intersectNumber = winningLottoToSet.intersect(purchaseLottoToSet)

        return when (intersectNumber.size) {
            FirstPlace.matchingNumberCnt -> FirstPlace
            SecondPlace.matchingNumberCnt -> SecondPlace
            ThirdPlace.matchingNumberCnt -> ThirdPlace
            FourthPlace.matchingNumberCnt -> FourthPlace
            else -> None
        }
    }

    fun createWinningRate(cash: Int, winningStatus: Map<LottoRanking, Int>): Float {
        val totalPrice = createTotalWinningPrice(winningStatus)

        return totalPrice / cash.toFloat()
    }

    private fun createTotalWinningPrice(winningStatus: Map<LottoRanking, Int>): Int {
        return winningStatus.toList().sumOf { it.first.findPrize(it) }
    }
}
