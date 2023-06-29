package lotto.view

import lotto.domain.Lottos
import lotto.model.LottoResultPrintModel

fun printBuyCount(manualBuyCount: Int, autoBuyCount: Int) {
    println("수동으로 ${manualBuyCount}장 자동으로 ${autoBuyCount}개를 구매했습니다.")
}

fun printLottoNumbers(lottoNumbers: Lottos) {
    lottoNumbers.lottos.forEach {
        println(it.lottoNumbers)
    }
    println()
}

fun printResultMessage() {
    println()
    println("당첨 통계")
    println("---------")
}

fun printResult(lottoResult: List<LottoResultPrintModel>, rateOfReturn: Float) {
    println(StringBuilder().append(rankingPrintInfo(lottoResult)).append(rateResultString(rateOfReturn)))
}

private fun rankingPrintInfo(lottoResult: List<LottoResultPrintModel>): String {
    val stringBuilder = StringBuilder()
    for (printModel in lottoResult) {
        stringBuilder.append(resultString(printModel.correctCount, printModel.price, printModel.count))
    }
    return stringBuilder.toString()
}

private fun resultString(correctCount: Int, price: Int, count: Int): String {
    return String.format("%d개 일치 (%d원)- %d개\n", correctCount, price, count)
}

private fun rateResultString(rateOfReturn: Float): String {
    return String.format(
        "총 수익률은 ${rateOfReturn}입니다.(기준이 1이기 때문에 결과적으로 ${LottoResultMessage.message(rateOfReturn)}라는 의미임"
    )
}
