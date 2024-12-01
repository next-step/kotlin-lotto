package autolotto.dto

class LottoResultResponse() { // private val winnerResults: Map<Prize, Int>
//
//    private val winnerResults = setWinnerResults(winnerResults)
//    private val profit: Double = setProfit(winnerResults, amount)
//
//    fun getWinnerResults(): List<String> = winnerResults
//    fun getProfit(): Double = profit
//
//    private fun setWinnerResults(winnerResults: Map<Int, Int>):List<String> {
//        return winnerResults.entries.map { m ->
//            setWinnerResult(m.key, m.value)
//        }.toList()
//    }
//
//    private fun setWinnerResult(
//        number: Int,
//        count: Int
//    ): String {
//        return when (number) {
//            3 -> "${number}개 일치 (${FOUR_PRIZE_MONEY}원) - ${count}개"
//            4 -> "${number}개 일치 (${THREE_PRIZE_MONEY}원) - ${count}개"
//            5 -> "${number}개 일치 (${SECOND_PRIZE_MONEY}원) - ${count}개"
//            6 -> "${number}개 일치 (${FIRST_PRIZE_MONEY}원) - ${count}개"
//            else -> throw RuntimeException("당첨 정보 없음")
//        }
//    }
//
//    private fun setProfit(winnerResults: Map<Int, Int>, amount: Int):Double {//계산을 여기서 ㅎ
//        val totalPrize: Int = LottoCalculator.getTotalPrize(winnerResults)
//        return LottoCalculator.getProfitRate(totalPrize, amount)
//    }
//
//
//    companion object {
//        private const val FOUR_PRIZE_MONEY = 5000
//        private const val THREE_PRIZE_MONEY = 50000
//        private const val SECOND_PRIZE_MONEY = 1500000
//        private const val FIRST_PRIZE_MONEY = 2000000000
//    }
}
