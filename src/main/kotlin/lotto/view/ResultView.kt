package lotto.view

import lotto.domain.model.LottoMatchResult
import lotto.domain.model.vo.RateOfReturn

private const val LOTTO_MATCH_RESULT_DESCRIPTION = "%d개 일치 (%d원)- %d개"
private const val LOTTO_RATE_OF_RETURN_DESCRIPTION = "총 수익률은 %.2f입니다.(기준이 %d이기 때문에 결과적으로 %s라는 의미임)"
private const val LOTTO_RATE_OF_RETURN_BENCHMARK_NUMBER = 1
private const val PROFIT = "이득이"
private const val LOSS = "손해"


/**
 * 결과 뷰
 * */
object ResultView {

    /**
     * 로또 일치 결과 뷰
     * */
    fun drawLottoMatchResult(lottoMatchResultList: List<LottoMatchResult>) {
        lottoMatchResultList.forEach { lottoResult ->
            println(LOTTO_MATCH_RESULT_DESCRIPTION.format(lottoResult.matchCount.matchCount, lottoResult.prize.prize, lottoResult.ticketCount.ticketCount))
        }
    }

    /**
     * 로또 수익률 결과 뷰
     * */
    fun drawLottoMatchResultRateOfReturn(rateOfReturn: RateOfReturn) {
        val resultText = if (rateOfReturn.rateOfReturn >= LOTTO_RATE_OF_RETURN_BENCHMARK_NUMBER.toDouble()) PROFIT else LOSS
        println(LOTTO_RATE_OF_RETURN_DESCRIPTION.format(rateOfReturn.rateOfReturn, LOTTO_RATE_OF_RETURN_BENCHMARK_NUMBER, resultText))
    }

}
