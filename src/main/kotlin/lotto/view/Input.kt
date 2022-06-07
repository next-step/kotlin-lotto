package lotto.view

import lotto.domain.LottoTicket.Companion.TICKET_PRICE

object Input {
    fun money(): Int {
        println("구입금액을 입력해 주세요.")
        return readln().toInt()
    }

    fun getRandomLottoNumsPerMoney(money: Int): List<List<Int>> {
        val ticketNumber = money.div(TICKET_PRICE)
        println(ticketNumber)

        return (1..ticketNumber)
            .map {
                val lottoNums = generateRandomLottoNums()
                println(lottoNums)

                lottoNums
            }
    }

    fun winNums(): List<Int> {
        println("지난 주 당첨 번호를 입력해 주세요.")
        val split = readln().split(",")

        return split.map { it.toInt() }
    }

    private fun generateRandomLottoNums(): List<Int> {
        val lottoNumRange = 1..45

        return lottoNumRange.shuffled().subList(0, 6)
    }
}
