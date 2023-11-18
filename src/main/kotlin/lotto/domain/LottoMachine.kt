package lotto.domain

import lotto.data.Lotto
import lotto.data.LottoNumber
import lotto.data.LottoRanking
import lotto.data.LottoRanking.FifthPlace
import lotto.data.LottoRanking.FirstPlace
import lotto.data.LottoRanking.FourthPlace
import lotto.data.LottoRanking.None
import lotto.data.LottoRanking.SecondPlace
import lotto.data.LottoRanking.ThirdPlace
import lotto.data.WinningLotto

object LottoMachine {

    fun createSelectLotto(lottoNumbers: Set<LottoNumber>): Lotto {
        return Lotto(lottoNumbers)
    }

    fun createWinningLotto(winningNumbers: List<Int>, bonusNumber: Int): WinningLotto {
        val winningLotto = LottoNumber.createLottoNumbers(winningNumbers)
        val bonusLottoNumber = LottoNumber.from(bonusNumber)
        return WinningLotto(Lotto(winningLotto), bonusLottoNumber)
    }

    fun checkLotto(purchaseLotto: Lotto, winningLotto: WinningLotto): LottoRanking {
        val intersectNumber = winningLotto.lotto.selectNumbers.intersect(purchaseLotto.selectNumbers)

        return when (intersectNumber.size) {
            FirstPlace.matchingNumberCnt -> FirstPlace
            SecondPlace.matchingNumberCnt, ThirdPlace.matchingNumberCnt -> {
                checkSecondPlace(purchaseLotto, winningLotto.bonusNumber)
            }
            FourthPlace.matchingNumberCnt -> FourthPlace
            FifthPlace.matchingNumberCnt -> FifthPlace
            else -> None
        }
    }

    fun createWinningRate(cash: Int, winningStatus: Map<LottoRanking, Int>): Float {
        val totalPrice = createTotalWinningPrice(winningStatus)

        return totalPrice / cash.toFloat()
    }

    private fun checkSecondPlace(purchaseLotto: Lotto, bonusLottoNumber: LottoNumber): LottoRanking {
        return if (purchaseLotto.selectNumbers.contains(bonusLottoNumber)) {
            SecondPlace
        } else {
            ThirdPlace
        }
    }

    private fun createTotalWinningPrice(winningStatus: Map<LottoRanking, Int>): Int {
        return winningStatus.toList().sumOf { it.first.findPrize(it) }
    }
}
