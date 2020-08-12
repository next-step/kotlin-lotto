package lotto

object ResultView {
    fun printBuyedLottoTicket(purchased: List<List<Int>>) {
        println("${purchased.size}개를 구매했습니다.")
        purchased.forEach { (println(it)) }
        print(" ")
    }
}
