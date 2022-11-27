package lotto.view

class ResultView {
    fun showQuantity(quantity: Int) {
        println("${quantity}개를 구매했습니다.")
    }

    fun showLottoTicket(lottoTicketNumber: List<Int>) {
        println(lottoTicketNumber)
    }

    fun showWinningStatistics() {
        println("당첨 통계")
        println("3개 일치 (5000원)- 개")
        println("4개 일치 (50000원)- 개")
        println("5개 일치 (1500000원)- 개")
        println("6개 일치 (2000000000원)- 개")
        println("총 수익률은 0.00입니다.")
    }
}
