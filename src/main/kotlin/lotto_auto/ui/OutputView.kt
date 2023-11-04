package lotto_auto.ui

object OutputView {
    fun print(list: List<List<Int>>) {
        list.forEach {
            println(it)
        }
    }

    fun showResult(matchResult: List<Int>, earningRate: Float) {
        println(LOTTO_STAT)
        println("---------")
        println(MATCH_THREE.format(matchResult.getOrElse(THIRD_INDEX) { DEFAULT_COUNT }))
        println(MATCH_FOUR.format(matchResult.getOrElse(FOURTH_INDEX) { DEFAULT_COUNT }))
        println(MATCH_FIVE.format(matchResult.getOrElse(FIFTH_INDEX) { DEFAULT_COUNT }))
        println(MATCH_SIX.format(matchResult.getOrElse(SIXTH_INDEX) { DEFAULT_COUNT }))
        println(TOTAL_EARNING_RATE.format(earningRate))
    }

    private const val LOTTO_STAT = "당첨 통계"
    private const val DEFAULT_COUNT = 0
    private const val MATCH_THREE = "3개 일치 (5000원) - %d개"
    private const val MATCH_FOUR = "4개 일치 (50000원 ) - %d개"
    private const val MATCH_FIVE = "5개 일치 (1500000원) - %d개"
    private const val MATCH_SIX = "6개 일치 (2000000000원) - %d개"
    private const val THIRD_INDEX = 0
    private const val FOURTH_INDEX = 1
    private const val FIFTH_INDEX = 2
    private const val SIXTH_INDEX = 3
    private const val TOTAL_EARNING_RATE = "총 수익률은 %.2f 입니다."
}
