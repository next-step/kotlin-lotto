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
            getFirstWinCount() * LottoResult.FirstWin.value.money + getSecondWinCount() * LottoResult.SecondWin.value.money + getThirdWinCount() * LottoResult.ThirdWin.value.money + getFourthWinCount() * LottoResult.FourthWin.value.money

        return (prize / (lottoResults.size * 1000.0) * 100).roundToInt() / 100.0
    }

    private fun giveStatistics(): String {
        val firstWinCounter = lottoResults.filter { it == LottoResult.FirstWin }.size
        val secondWinCounter = lottoResults.filter { it == LottoResult.SecondWin }.size
        val thirdWinCounter = lottoResults.filter { it == LottoResult.ThirdWin }.size
        val fourthWinCounter = lottoResults.filter { it == LottoResult.FourthWin }.size

        val prize =
            firstWinCounter * LottoResult.FirstWin.value.money + secondWinCounter * LottoResult.SecondWin.value.money + thirdWinCounter * LottoResult.ThirdWin.value.money + fourthWinCounter * LottoResult.FourthWin.value.money

        var string = "3개 일치 (5000원)- ${fourthWinCounter}개\n"
        string += "4개 일치 (50000원)- ${thirdWinCounter}개\n"
        string += "5개 일치 (1500000원)- ${secondWinCounter}개\n"
        string += "6개 일치 (2000000000원)- ${firstWinCounter}개\n"

        string += "총 수익률은 ${(prize / (lottoResults.size * 1000.0) * 100).roundToInt() / 100.0}입니다. (기준이 1이기 때문에 결과적으로 손해라는 의미임"
        return string
    }

    override fun toString(): String {
        return giveStatistics()
    }
}
