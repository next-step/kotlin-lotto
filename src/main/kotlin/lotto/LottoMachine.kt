package lotto

import lotto.LottoConst.Companion.endNumber
import lotto.LottoConst.Companion.lottoPay
import lotto.LottoConst.Companion.maxCount
import lotto.LottoConst.Companion.startNumber
import lotto.utils.NumberUtil

class LottoMachine {

    fun issue(amount: Int): LottoPaper {
        require(lottoPay <= amount)
        return LottoPaper(makeLottoNumbers(amount))
    }

    fun getLottoRank(winnerNumber: WinnerNumber, lottoPaper: LottoPaper): LottoRankPaper {
        return LottoRankPaper(lottoPaper.lottoNumbers.map { LottoRank.matchRank(winnerNumber, it) })
    }

    private fun makeLottoNumbers(amount: Int): List<LottoNumber> {
        return (1..(amount / lottoPay)).map {
            LottoNumber(NumberUtil.makeNumbers(maxCount, startNumber, endNumber))
        }
    }
}
