package lotto

object ResultView {
    fun printBuyResult(lottos: List<Lotto>) {
        println("${lottos.size}개를 구매했습니다")
        lottos.forEach {
            println(it.numbers.sorted())
        }
        println()
    }

    fun printLottoResult(results: List<Int>, earningRate: Double, profitState: ProfitState) {
        println("\n당첨 통계")
        println("---------")
        for (i in 3..6) {
            println("${i}개 일치 (${Lotto.prizes[i]}원) - ${results[i]}개")
        }
        println("총 수익률은 ${earningRate}입니다.(기준이 1이기 때문에 결과적으로 ${profitState.fixGrammar()}라는 의미임)")
    }

    fun printMessage(message: String) = println(message)

    private fun ProfitState.fixGrammar(): String {
        return when (this) {
            ProfitState.PROFIT, ProfitState.SAME -> "${message}이"
            else -> message
        }
    }
}
