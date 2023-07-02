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
        purchasedLottos.forEach { println(it.purchasedLottoNumbers.toString()) }
    }

    fun readLastWeekWinningString(): String {
        println("지난 주 당첨 번호를 입력해 주세요.")
        return readln()
    }

    fun readLastWeekBonusBallNumber(): Int {
        println("보너스 볼을 입력해 주세요.")
        return readln().toInt()
    }
}
