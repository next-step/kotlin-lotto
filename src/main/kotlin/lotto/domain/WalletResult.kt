package lotto.domain

import kotlin.math.roundToInt

class WalletResult(private val lottoResults: List<LottoResult>) {
    fun getFirstWinCount(): Int {
        return lottoResults.filter { it == LottoResult.FirstWin }.size
    }

    fun getSecondWinCount(): Int {
        return lottoResults.filter { it == LottoResult.SecondWin }.size
    }

    fun getThirdWinCount(): Int {
        return lottoResults.filter { it == LottoResult.ThirdWin }.size
    }

    fun getFourthWinCount(): Int {
        return lottoResults.filter { it == LottoResult.FourthWin }.size
    }

    fun getRateOfReturn(): Double {
        val prize =
            getFirstWinCount() * LottoResult.FirstWin.KRW.money + getSecondWinCount() * LottoResult.SecondWin.KRW.money + getThirdWinCount() * LottoResult.ThirdWin.KRW.money + getFourthWinCount() * LottoResult.FourthWin.KRW.money

        return (prize / (lottoResults.size * 1000.0) * 100).roundToInt() / 100.0
    }
}
