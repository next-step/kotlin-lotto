package lotto

import kotlin.math.floor

class WinningStatics(
    private val payment: Int,
    private val winningLottoNumber: List<Int>,
    private val lottoRecord: List<LottoNumberSet>
) {

    fun run(): WinningStaticsResponseDto {
        val containCountList: List<Int> = lottoRecord.map {
            containsCount(it)
        }

        val matchWinningLotto: Map<LottoWinningAmount, Int> = LottoWinningAmount.values()
            .associateWith { lottoWinningAmount ->
                containCountList.count { it == lottoWinningAmount.matchCount }
            }

        val profitRatio: Double = profitRatio1(matchWinningLotto)

        return WinningStaticsResponseDto(matchWinningLotto, profitRatio)
    }

    private fun containsCount(lottoNumberSet: LottoNumberSet): Int = lottoNumberSet.lotto
        .sumOf {
            if (winningLottoNumber.contains(it)) 1.toInt() else 0
        }

    private fun profitRatio(matchWinningLotto: Map<LottoWinningAmount, Int>): Double = matchWinningLotto
        .map { (lottoWinningAmount, count) ->
            lottoWinningAmount.winningAmount * count
        }
        .sum()
        .toDouble() / payment

    private fun profitRatio1(matchWinningLotto: Map<LottoWinningAmount, Int>): Double {
        val result: Double = matchWinningLotto
            .map { (lottoWinningAmount, count) ->
                lottoWinningAmount.winningAmount * count
            }
            .sum()
            .toDouble() / payment
        return floor((result * 100)) / 100
    }
}
