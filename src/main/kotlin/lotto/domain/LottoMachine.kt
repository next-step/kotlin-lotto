package lotto.domain

import lotto.data.Lotto
import lotto.data.LottoNumber
import lotto.data.LottoRanking
import lotto.data.LottoRanking.FifthPlace
import lotto.data.LottoRanking.FirstPlace
import lotto.data.LottoRanking.FourthPlace
import lotto.data.LottoRanking.None
import lotto.data.LottoRanking.ThirdPlace
import lotto.data.WinningLotto

object LottoMachine {

    fun createSelectLotto(lottoNumbers: Set<LottoNumber>): Lotto {
        return Lotto(lottoNumbers)
    }

    fun createWinningLotto(lottoNumbers: Set<LottoNumber>, bonusLottoNumber: LottoNumber): WinningLotto {
        return WinningLotto(Lotto(lottoNumbers), bonusLottoNumber)
    }

    fun checkLotto(purchaseLotto: Lotto, winningLotto: Lotto): LottoRanking {
        val winningLottoToSet = winningLotto.selectNumbers.toSet()
        val purchaseLottoToSet = purchaseLotto.selectNumbers.toSet()
        val intersectNumber = winningLottoToSet.intersect(purchaseLottoToSet)

        return when (intersectNumber.size) {
            FirstPlace.matchingNumberCnt -> FirstPlace
            ThirdPlace.matchingNumberCnt -> ThirdPlace
            FourthPlace.matchingNumberCnt -> FourthPlace
            FifthPlace.matchingNumberCnt -> FifthPlace
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
