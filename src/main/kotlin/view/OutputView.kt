package view

import domain.Lottery

object OutputView {

    fun reportPrizeState(lottery: Lottery) {
        println(lottery.randomNumbers.toString())
    }

    fun reportPrize(
        prizeMessage: String,
        count: Int
    ) {
        println("$prizeMessage- ${count}개")
    }

    fun reportProfit(returnOnInvestment: Double) {
        val formattedROI = "%.2f".format(returnOnInvestment)
        val message = if (returnOnInvestment > 1) {
            "이익을 얻었습니다."
        } else {
            "(기준이 1이기 때문에 결과적으로 손해라는 의미임)"
        }
        println("총 수익률은 ${formattedROI}입니다.$message")
    }

    fun reportPurchaseHistory(lottoSize: Int) {
        println("${lottoSize}개를 구매했습니다.")
    }
}
