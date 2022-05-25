package lotto

class ResultView(private val output: Output) {
    fun showLottos(lottos: List<Lotto>) {
        output.print("${lottos.size}개를 구입했습니다.")
        lottos.forEach { output.print(it.toString()) }
    }

    fun showAnalyzeResult(lottoResult: LottoResultDto) {
        println("당첨 통계")
        println("---------")
        output.print(buildMatchPrizeResultFor(lottoResult.fourthPrize))
        output.print(buildMatchPrizeResultFor(lottoResult.thirdPrize))
        output.print(buildMatchPrizeResultFor(lottoResult.secondPrize))
        output.print(buildMatchPrizeResultFor(lottoResult.firstPrize))
        output.print(buildRateOfReturnFor(lottoResult.rateOfReturn))
    }

    private fun buildMatchPrizeResultFor(prize: PrizeDto) =
        "${prize.matchCount}개 일치 (${prize.price}원)- ${prize.numberOfCorrect}개"

    private fun buildRateOfReturnFor(rateOfReturn: String) =
        "총 수익률은 ${rateOfReturn}입니다.(기준이 1이기 때문에 결과적으로 ${if (rateOfReturn.toDouble() > 1) "이득이" else "손해"}라는 의미임)"
}
