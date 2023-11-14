package lotto.view

import lotto.domain.LotteryResult
import lotto.domain.Lotto
import lotto.domain.LottoBundle

object OutputView {

    fun printPurchaseQuantity(quantity: Int) {
        println("${quantity}개를 구매했습니다.")
    }

    fun printPurchaseLottoBundle(lottoBundle: LottoBundle) {
        lottoBundle.bundle.forEach { lotto ->
            println(sortByLottoNumbersASC(lotto))
        }
    }

    private fun sortByLottoNumbersASC(lotto: Lotto) = lotto.lottoNumbers.map { lottoNumber ->
        lottoNumber.lottoNumber
    }.sortedBy {
        it
    }

    fun printLotteryResult(lotteryResult: LotteryResult) {
        println("당첨 통계")
        println("--------")
        lotteryResult.rankRecord.forEach { record ->
            println("${record.matchCount}개 일치 (${record.reward}원)- ${record.recordCount}개")
        }
        printRateOfReturn(lotteryResult)
    }

    private fun printRateOfReturn(lotteryResult: LotteryResult) {
        println(
            "총 수익률은 ${lotteryResult.rate}입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)"
        )
    }
}
