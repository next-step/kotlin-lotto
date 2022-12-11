package lotto.view

import lotto.domain.Cash
import lotto.domain.LottoWinTicket

object InputViewImpl {

    fun readCash(): Cash {
        println("구입금액을 입력해 주세요.")
        return Cash(readln())
    }

    fun readWinNumber(): LottoWinTicket {
        println("지난 주 당첨 번호를 입력해 주세요.")
        return LottoWinTicket.from(readln())
    }
}
