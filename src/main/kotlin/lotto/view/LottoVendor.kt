package lotto.view

import lotto.model.Lotto

object LottoVendor {
    fun saleLottoTicket(): Int {
        println("구매 금액을 입력해주세요.")
        return readln().toInt()
    }

    fun saleLottoTicket(ticketCount: Int) {
        println("$ticketCount 개를 구매했습니다.")
    }

    fun printLottoNumber(purchasedLottos:List<Lotto>) {
        purchasedLottos.forEach { print(it) }
    }

    fun readLastWeekWinningString(): String {
        println("지난 주 당첨 번호를 입력해 주세요.")
        return readLine().toString()
    }
}