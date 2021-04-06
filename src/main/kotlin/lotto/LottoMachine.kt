package lotto

import lotto.LottoConst.Companion.endNumber
import lotto.LottoConst.Companion.lottoPay
import lotto.LottoConst.Companion.maxCount
import lotto.LottoConst.Companion.startNumber
import lotto.utils.NumberUtil

class LottoMachine {

    fun issue(amount: Int, handwritingNumbers: List<String>): LottoPaper {
        require(lottoPay <= amount)
        val remainderAmount = amount - (lottoPay * handwritingNumbers.size)
        return makeLottoPaper(remainderAmount, handwritingNumbers)
    }

    fun getLottoRank(winnerNumber: WinnerNumber, lottoPaper: LottoPaper): LottoRankPaper {
        return LottoRankPaper(lottoPaper.lottoNumbers.map { LottoRank.matchRank(winnerNumber, it) })
    }

    private fun makeLottoPaper(amount: Int, handwritingNumbers: List<String>): LottoPaper {
        val allLottoNumbers = mutableListOf<LottoNumber>()
        makeLottoNumbers(handwritingNumbers).let { allLottoNumbers.addAll(it) }
        allLottoNumbers.addAll(makeLottoNumbers(amount))
        return LottoPaper(allLottoNumbers.toList())
    }

    private fun makeLottoNumbers(amount: Int): List<LottoNumber> {
        return (1..(amount / lottoPay)).map {
            LottoNumber(NumberUtil.makeNumbers(maxCount, startNumber, endNumber))
        }
    }

    private fun makeLottoNumbers(handwritingNumbers: List<String>): List<LottoNumber> {
        return handwritingNumbers.map {
            LottoNumber(it.split(",").map { numberAsString -> numberAsString.trim().toInt() })
        }
    }
}
