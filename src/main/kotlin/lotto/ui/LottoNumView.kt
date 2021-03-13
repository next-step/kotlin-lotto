package lotto.ui

import lotto.data.BuyingData
import lotto.data.LottoNumbers
import lotto.domain.LotteryTicket

object LottoNumView {
    fun printTickets(lotteryTickets: List<LotteryTicket>) {
        lotteryTickets.forEach {
            printLottoNumbers(it.lottoNumbers)
        }
    }

    private fun printLottoNumbers(lottoNumbers: LottoNumbers) {
        println(lottoNumbers.lottoNumbers.map { it.value })
    }

    fun printTicketNumber(buyingData: BuyingData) {
        println("수동으로 ${buyingData.manualTicketCount}장, 자동으로 ${buyingData.autoTicketCount}개를 구매했습니다.")
    }
}
