package lotto

object LottoOutputView {
    fun outputPurchaseLottoTicketCount(lottoPurchaseAmount: Money) {
        println("${lottoPurchaseAmount.lottoTicketCount()}개를 구매했습니다.")
    }

    fun outputPurchaseLottoTickerInfos(lottoTickets: LottoTickets) {
        lottoTickets.forEach() { lottoTicket ->
            println(lottoTicket.lottoNumbers.map { it.value }.joinToString(prefix = "[", postfix = "]"))
        }
        println()
    }

    fun outputLottoResults(lottoPrizes: LottoResults, lottoPurchaseAmount: Money) {
        println()
        println("당첨 통계")
        println("---------")
        println("3개 일치 (5000원)- ${lottoPrizes.firstPlaceCount}개")
        println("4개 일치 (50000원)- ${lottoPrizes.forthPlaceCount}개")
        println("5개 일치 (1500000원)- ${lottoPrizes.thirdPlaceCount}개")
        println("5개 일치, 보너스 볼 일치(30000000원)- ${lottoPrizes.secondPlaceCount}개")
        println("6개 일치 (2000000000원)- ${lottoPrizes.firstPlaceCount}개")
        println(String.format("총 수익률은 %.2f입니다.(구매한 원금은 1.0입니다)", lottoPrizes.totalPrize.toFloat() / lottoPurchaseAmount.value.toFloat()))
    }
}
