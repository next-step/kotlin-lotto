package lotto.domain

import lotto.data.Lotto
import lotto.data.LottoNumber
import lotto.data.LottoRanking
import lotto.data.WinningLotto
import java.util.EnumMap

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
        val matchingNumberCnt = winningLotto.countMatchingNumbers(purchaseLotto)
        val hasBonusNumber = winningLotto.hasBonusNumber(purchaseLotto)

        return LottoRanking.findLottoRanking(matchingNumberCnt, hasBonusNumber)
    }

    fun createWinningRate(cash: Int, winningStatus: EnumMap<LottoRanking, Int>): Float {
        return LottoCalculator.calculateWinningRate(cash, winningStatus)
    }
}
