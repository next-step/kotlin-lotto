package lotto.infra.io

import lotto.domain.lotto.number.LottoNumber
import lotto.domain.lotto.price.LottoCost
import lotto.domain.lotto.ticket.LottoTicket

class LottoInputReader {

    fun readLottoCost(): LottoCost {
        return LottoCost(readLine().toInt())
    }

    fun readLottoBonusNumber(): LottoNumber {
        return LottoNumber(readLine().toInt())
    }

    fun readLottoTicket(): LottoTicket {
        return LottoTicket(readLine().split(",").map { LottoNumber(it.trim().toInt()) })
    }

    private fun readLine(): String = readln().trim()
}
