package lotto.domain

import kotlin.math.round

class LottoStatistics(
    private val money: Int,
    private val lottoNumbers: List<LottoNumbers>,
    private val winningLottoNumbers: List<LottoNumber>,
    private val winningLottoBonusNumber: LottoNumber
) {
    val earningRate: Double
    val resultMap: Map<LottoMatch, Int>

    init {
        earningRate = calculateEarningRate(money, calculateWinningTotalMoney(lottoNumbers, winningLottoNumbers, winningLottoBonusNumber))
        resultMap = HashMap<LottoMatch, Int>()
        LottoMatch.values().forEach {
            val countSize = getLottoWinningCountOfLottoRank(lottoNumbers, winningLottoNumbers, winningLottoBonusNumber, it)
            resultMap.put(it, countSize)
        }
    }

    private fun calculateWinningTotalMoney(
        lottoNumbers: List<LottoNumbers>,
        winningLottoNumbers: List<LottoNumber>,
        winningLottoBonusNumber: LottoNumber
    ): Int {
        require(winningLottoNumbers.size == WINNING_LOTTO_NUMBER_SIZE) { WINNING_LOTTO_NUMBER_SIZE_MESSAGE }
        require(!winningLottoNumbers.contains(winningLottoBonusNumber)) { DUPLICATE_LOTTO_BONUS_NUMBER }
        return lottoNumbers.sumOf { lotto ->
            val count = lotto.getCountWithWinningLottoNumber(winningLottoNumbers)
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
        winningLottoNumbers: List<LottoNumber>,
        winningLottoBonusNumber: LottoNumber,
        lottoMatch: LottoMatch
    ): Int {
        return lottoNumbers.filter { lotto ->
            val count = lotto.getCountWithWinningLottoNumber(winningLottoNumbers)
            val hasBonusNumber = lotto.hasBonusNumber(winningLottoBonusNumber)
            LottoMatch.findLottoMatch(count, hasBonusNumber) == lottoMatch
        }.size
    }

    companion object {
        const val WINNING_LOTTO_NUMBER_SIZE = 6
        const val WINNING_LOTTO_NUMBER_SIZE_MESSAGE = "당첨 번호 입력시 6개의 숫자를 입력해주셔야 합니다."
        const val DUPLICATE_LOTTO_BONUS_NUMBER = "보너스 번호가 중복된 번호입니다."
    }
}
