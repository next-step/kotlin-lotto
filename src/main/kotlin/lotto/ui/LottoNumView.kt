package lotto.ui

import lotto.domain.LotteryTicket

object LottoNumView {
    fun printLottoNumbers(lotteryTickets: List<LotteryTicket>) {
        lotteryTickets.forEach {
            println(it.lottoNumbers.lottoNumbers)
        }
    }
}
