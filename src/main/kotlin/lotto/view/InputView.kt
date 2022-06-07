package lotto.view

import lotto.domain.Lotto
import lotto.domain.LottoNumber
import lotto.domain.Money
import lotto.domain.Tickets

class InputView {
    fun getMoney(): Int {
        println(INPUT_MONEY)
        return readln().toInt()
    }

    fun getPastWinner(): Lotto {
        println(INPUT_LAST_WINNER)
        return parseToLotto(readln())
    }

    fun getBonusNumber(): LottoNumber {
        println(INPUT_BONUS_NUMBER)
        return LottoNumber(readln().toInt())
    }

    fun getManualTickets(money: Money): Tickets? {
        println(INPUT_MANUAL_TICKET_COUNT)
        val count = readln().toInt()

        if (count == 0) return null

        println(INPUT_MANUAL_TICKET_NUMBER)
        return Tickets(List(count) { parseToLotto(readln()) })
    }

    private fun parseToLotto(input: String): Lotto {
        return Lotto.of(input.split(LOTTO_SPLIT_DELIMITER).map { it.toInt() }.toSet())
    }

    companion object {
        private const val INPUT_MONEY = "구입금액을 입력해 주세요."
        private const val INPUT_LAST_WINNER = "지난 주 당첨 번호를 입력해 주세요."
        private const val INPUT_BONUS_NUMBER = "보너스 볼을 입력해 주세요."
        private const val INPUT_MANUAL_TICKET_COUNT = "수동으로 구매할 로또 수를 입력해 주세요."
        private const val INPUT_MANUAL_TICKET_NUMBER = "수동으로 구매할 번호를 입력해 주세요."

        private const val LOTTO_SPLIT_DELIMITER = ","
    }
}
