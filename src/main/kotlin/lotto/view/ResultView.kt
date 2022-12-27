package lotto.view

object ResultView {

    fun printTicketAmount(amount: Int) {
        println("${amount}개를 구매했습니다.")
    }

    fun printRateOfReturn(rate: Float) {
        println("총 수익률은 ${rate}입니다.")
    }
}
