package lotto

class LottoResultList(resultList: List<LottoRank>) {
    val firstNum = resultList.count { it == LottoRank.FIRST }
    val secondNum = resultList.count { it == LottoRank.SECOND }
    val thirdNum = resultList.count { it == LottoRank.THIRD }
    val fourthNum = resultList.count { it == LottoRank.FOURTH }

    private val prizeMoney = firstNum * LottoRank.FIRST.money +
            secondNum * LottoRank.SECOND.money +
            thirdNum * LottoRank.THIRD.money +
            fourthNum * LottoRank.FOURTH.money

    fun getProfitRate(buy: Int): Float {
        return prizeMoney / buy.toFloat()
    }
}
