package lotto.ui

import lotto.data.LotteryTicketNumbers

object LottoNumView {
    fun printLottoNumbers(lotteryTicketNumbers: LotteryTicketNumbers) {
        lotteryTicketNumbers.lotteryTicketNumbers.forEach {
            println(it.numbers)
        }
    }
}