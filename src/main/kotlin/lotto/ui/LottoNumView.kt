package lotto.ui

import lotto.data.LottoNumbers
import lotto.domain.LotteryTicket

object LottoNumView {
    fun printTickets(lotteryTickets: List<LotteryTicket>) {
        lotteryTickets.forEach {
            printLottoNumbers(it.lottoNumbers)
        }
    }

    private fun printLottoNumbers(lottoNumbers: LottoNumbers) {
        println(lottoNumbers.toIntList())
    }
}
