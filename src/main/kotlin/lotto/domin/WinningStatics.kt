package lotto.domin

import lotto.domin.LottoWinningAmount.Companion.matchWinningLotto
import lotto.dto.InputPaymentRequestDto
import lotto.dto.InputLottoNumberDto
import lotto.dto.WinningStaticsResponseDto
import kotlin.math.floor

class WinningStatics(
    paymentDto: InputPaymentRequestDto,
    lastWeekWinningLottoDto: InputLottoNumberDto,
    private val lottoRecord: List<LottoNumberSet>
) {
    private val payment: Int = paymentDto.payment
    private val winningLottoNumber: List<Int> = lastWeekWinningLottoDto.lasWeekWinningNumber
    private val bonusNumber: Int = lastWeekWinningLottoDto.bonusNumber

    fun result(): WinningStaticsResponseDto {
        val sameLottoNumberCount: List<MatchCount> = lottoRecord.map {
            MatchCount(containsCount(it), containBonusBall(it))
        }

        val matchWinningLotto: Map<LottoWinningAmount, Int> = matchWinningLotto(sameLottoNumberCount)

        val profitRatio: Double = profitRatio(matchWinningLotto)

        return WinningStaticsResponseDto(matchWinningLotto, profitRatio)
    }

    private fun containsCount(lottoNumberSet: LottoNumberSet): Int = lottoNumberSet.lotto
        .sumOf {
            if (winningLottoNumber.contains(it)) 1.toInt() else 0
        }

    private fun containBonusBall(lottoNumberSet: LottoNumberSet): Int = lottoNumberSet.lotto
        .sumOf {
            if (it == bonusNumber) 1.toInt() else 0
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
