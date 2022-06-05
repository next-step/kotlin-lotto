package lotto.domain

import kotlin.math.round

class LottoStatistics(
    private val money: Int,
    private val lottoNumbers: List<LottoNumbers>,
    private val winningLottoNumbers: List<LottoNumber>
) {
    val earningRate: Double
    val resultMap: Map<LottoMatch, Int>

    init {
        earningRate = calculateEarningRate(money, calculateWinningTotalMoney(lottoNumbers, winningLottoNumbers))
        resultMap = HashMap<LottoMatch, Int>()
        LottoMatch.values().forEach {
            val countSize = getLottoWinningCountOfLottoRank(lottoNumbers, winningLottoNumbers, it.count)
            resultMap.put(it, countSize)
        }
    }

    private fun calculateWinningTotalMoney(lottoNumbers: List<LottoNumbers>, winningLottoNumbers: List<LottoNumber>): Int {
        require(winningLottoNumbers.size == WINNING_LOTTO_NUMBER_SIZE) { WINNING_LOTTO_NUMBER_SIZE_MESSAGE }
        return lottoNumbers.sumOf { lotto ->
            val count = lotto.getCountWithWinningLottoNumber(winningLottoNumbers)
            LottoMatch.findLottoMatch(count).prize
        }
    }

    private fun calculateEarningRate(money: Int, winningTotalMoney: Int): Double {
        return round(winningTotalMoney / money.toDouble() * 100) / 100
    }

    private fun getLottoWinningCountOfLottoRank(lottoNumbers: List<LottoNumbers>, winningLottoNumbers: List<LottoNumber>, count: Int): Int {
        return lottoNumbers.filter { lotto ->
            lotto.getCountWithWinningLottoNumber(winningLottoNumbers) == count
        }.size
    }

    companion object {
        const val WINNING_LOTTO_NUMBER_SIZE = 6
        const val WINNING_LOTTO_NUMBER_SIZE_MESSAGE = "당첨 번호 입력시 6개의 숫자를 입력해주셔야 합니다."
    }
}
