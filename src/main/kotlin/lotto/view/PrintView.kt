package lotto.view

import lotto.domain.LottoNumbers
import lotto.domain.LottoRanking

fun printBuyCount(price: Int) {
    print("${(price / 1000)}개를 구매했습니다.")
    println()
}

fun printLottoNumbers(lottoNumbers: List<LottoNumbers>) {
    lottoNumbers.forEach {
        println(it.lottoNumbers)
    }
    println()
}

fun printResultMessage() {
    println()
    println("당첨 통계")
    println("---------")
}

fun printResult(lottoResult: Map<LottoRanking, Int>, rateOfReturn: Float) {
    println(StringBuilder().append(rankingPrintInfo(lottoResult)).append(rateResultString(rateOfReturn)))
}

private fun rankingPrintInfo(lottoResult: Map<LottoRanking, Int>): String {
    return LottoRanking.values()
        .filter { ranking -> ranking != LottoRanking.MISS }
        .map { lottoResult[it]?.let { it1 -> resultString(it, it1) } }
        .sortedBy { it }
        .joinToString("")
}

private fun resultString(lottoRanking: LottoRanking, count: Int): String? {
    return String.format("%d개 일치 (%d원)- %d개\n", lottoRanking.correctCount, lottoRanking.price, count)
}

private fun rateResultString(rateOfReturn: Float): String? {
    return java.lang.String.format(
        "총 수익률은 ${rateOfReturn}입니다.(기준이 1이기 때문에 결과적으로 ${LottoResultMessage.message(rateOfReturn)}라는 의미임"
    )
}
