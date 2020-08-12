package lotto

import lotto.InputNumber.winningNumberInput

object ResultView {
    fun printBuyedLottoTicket(purchased: List<Lotto>) {
        print("${purchased.size}개를 구매했습니다.")
        purchased.map { it.tickets(purchased.size) }
        print(" ")
    }

    fun printWinningNumber() {
        print(winningNumberInput())
    }
}
