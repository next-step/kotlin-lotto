package lotto.domain

import java.util.EnumMap
import kotlin.math.round

class LottoStatistics(
    money: Int,
    private val lottoNumbers: List<LottoNumbers>,
    private val winningLottoNumbers: LottoNumbers,
    private val winningLottoBonusNumber: LottoNumber
) {
    val earningRate: Double
    val resultMap: Map<LottoMatch, Int>

    init {
        require(!winningLottoNumbers.lottoNumbers.contains(winningLottoBonusNumber)) { LOTTO_BONUS_NUMBER_DUPLICATE }

        earningRate = calculateEarningRate(money, calculateWinningTotalMoney(lottoNumbers, winningLottoNumbers, winningLottoBonusNumber))
        resultMap = EnumMap(LottoMatch::class.java)
        LottoMatch.values().forEach {
            val countSize = getLottoWinningCountOfLottoRank(lottoNumbers, winningLottoNumbers, winningLottoBonusNumber, it)
            resultMap.put(it, countSize)
        }
    }

    private fun calculateWinningTotalMoney(
        lottoNumbers: List<LottoNumbers>,
        winningLottoNumbers: LottoNumbers,
        winningLottoBonusNumber: LottoNumber
    ): Int {
        return lottoNumbers.sumOf { lotto ->
            val count = lotto.getCountWithWinningLottoNumber(LottoNumbers(winningLottoNumbers.lottoNumbers))
            val hasBonusNumber = lotto.hasBonusNumber(winningLottoBonusNumber)
            LottoMatch.findLottoMatch(count, hasBonusNumber).prize
        }
    }

    private fun calculateEarningRate(
        money: Int,
        winningTotalMoney: Int
    ): Double {
        return round(winningTotalMoney / money.toDouble() * 100) / 100
    }

    private fun getLottoWinningCountOfLottoRank(
        lottoNumbers: List<LottoNumbers>,
        winningLottoNumbers: LottoNumbers,
        winningLottoBonusNumber: LottoNumber,
        lottoMatch: LottoMatch
    ): Int {
        return lottoNumbers.filter { lotto ->
            val count = lotto.getCountWithWinningLottoNumber(LottoNumbers(winningLottoNumbers.lottoNumbers))
            val hasBonusNumber = lotto.hasBonusNumber(winningLottoBonusNumber)
            LottoMatch.findLottoMatch(count, hasBonusNumber) == lottoMatch
        }.size
    }

    companion object {
        private const val LOTTO_BONUS_NUMBER_DUPLICATE = "보너스 번호가 당첨 번호 내 번호와 중복됩니다."
    }
}
