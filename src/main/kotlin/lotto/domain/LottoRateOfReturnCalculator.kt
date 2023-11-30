package lotto.domain

import lotto.domain.model.vo.BuyPrice
import lotto.domain.model.LottoMatchResult
import lotto.domain.model.vo.RateOfReturn

/**
 * 수익률 계산기
 * */
object LottoRateOfReturnCalculator {

    /**
     * 수익률 계산
     * */
    fun rateOfReturn(buyPrice: BuyPrice, lottoMatchResultList: List<LottoMatchResult>): RateOfReturn {

        val returnValues = lottoMatchResultList.sumOf { lottoMatchResult ->
            lottoMatchResult.prize.value * lottoMatchResult.winningTicketCount.value
        }
        return RateOfReturn.valueOf(returnValues.toDouble() / buyPrice.value)
    }
}
