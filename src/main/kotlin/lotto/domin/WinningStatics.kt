package lotto.domin

import lotto.dto.InputPaymentRequestDto
import lotto.dto.InputWinningLottoNumberDto
import lotto.dto.WinningStaticsResponseDto
import kotlin.math.floor

class WinningStatics(
    paymentDto: InputPaymentRequestDto,
    lastWeekWinningLottoDto: InputWinningLottoNumberDto,
    private val lottoRecord: List<LottoNumberSet>
) {
    private val payment: Int = paymentDto.payment
    private val winningLottoNumber: List<Int> = lastWeekWinningLottoDto.lasWeekWinningNumber

    fun result(): WinningStaticsResponseDto {
        val containCountList: List<Int> = lottoRecord.map {
            containsCount(it)
        }

        val matchWinningLotto: Map<LottoWinningAmount, Int> = LottoWinningAmount.values()
            .associateWith { lottoWinningAmount ->
                containCountList.count { it == lottoWinningAmount.matchCount }
            }

        val profitRatio: Double = profitRatio(matchWinningLotto)

        return WinningStaticsResponseDto(matchWinningLotto, profitRatio)
    }

    private fun containsCount(lottoNumberSet: LottoNumberSet): Int = lottoNumberSet.lotto
        .sumOf {
            if (winningLottoNumber.contains(it)) 1.toInt() else 0
        }

    private fun profitRatio(matchWinningLotto: Map<LottoWinningAmount, Int>): Double {
        val result: Double = matchWinningLotto
            .map { (lottoWinningAmount, count) ->
                lottoWinningAmount.winningAmount * count
            }
            .sum()
            .toDouble() / payment
        return floor((result * 100)) / 100
    }
}
