package view

object OutputView {

    fun announcePrize(
        idx: Int,
        prize: Int,
        count: Int
    ) {
        println("${idx}개 일치 (${prize}원) - $count")
    }

    fun reportProfit(returnOnInvestment: Double) {
        val formattedROI = "%.2f".format(returnOnInvestment)
        val message = if (returnOnInvestment > 1) {
            "이익을 얻었습니다."
        } else {
            "(기준이 1이기 때문에 결과적으로 손해라는 의미임)"
        }
        println("총 수익률은 ${formattedROI}입니다.${message}개")
    }
}
