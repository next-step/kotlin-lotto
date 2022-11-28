package lotto.infra.io

import lotto.domain.lotto.price.LottoCost
import lotto.domain.lotto.ticket.LottoAnswerTicket

class LottoInputReader {

    fun readLottoCost(): LottoCost {
        return LottoCost(readLine().toInt())
    }

    fun readLottoAnswer(): LottoAnswerTicket {
        return LottoAnswerTicket(*readLine().split(",").map { it.trim().toInt() }.toIntArray())
    }

    private fun readLine(): String = readln().trim()
}
