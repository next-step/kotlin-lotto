package lotto

object OutputView {
    private const val PRINT_VALID_MATCH_COUNT = 3

    fun printLotto(userLotto: List<LottoNumbers>) {
        println("${userLotto.size}개를 구매했습니다.")
        userLotto.forEach { println("[${it}]") }.also { println() }
    }

    fun printResult(result: List<LottoResult>) {
        StringBuilder().apply {
            append("\n당첨 통계\n")
            append("---------\n")
            result.forEach {
                if(it.lottoRank.matchCount >= PRINT_VALID_MATCH_COUNT) {
                    append("${it.lottoRank.matchCount}개 일치 ")
                    append("(${it.lottoRank.winningPrice.value}원) - ${it.count}개\n")
                }
            }
        }.also(::println)
    }

    fun printProfitRate(computeProfitRate: Double) {
        println("총 수익률은 $computeProfitRate 입니다.")
    }
}