package lotto.ui

import lotto.domain.Ticket

/**
 *
 * @author Leo
 */
class InputView {

    fun getAmount(): Int {
        println("구입금액을 입력해 주세요.")
        return readLine()!!.trim().toInt()
    }

    fun showTicketCount(tickets: List<Ticket>, manualCount: String) {
        println("수동으로 ${manualCount}장, 자동으로 ${tickets.size - manualCount.toInt()}개를 구매했습니다.")
        tickets.forEach {
            println(it.numbers)
        }
        println("")
    }

    fun getWinningNumbers(): List<Int> {
        println("지난 주 당첨 번호를 입력해 주세요.")
        return readLine()!!.trim().split(SEPERATOR).map { it.toInt() }
    }

    fun getBonusNumber(): String {
        println("보너스 볼을 입력해 주세요.")
        return readLine()!!
    }

    fun getManualTicketCount(): String {
        println("수동으로 구매할 로또 수를 입력해 주세요.")
        return readLine()!!
    }

    fun getManualTicketNumbers(count: Int): MutableList<List<Int>> {
        println("수동으로 구매할 번호를 입력해 주세요.")
        val numbers = mutableListOf<List<Int>>()
        IntRange(1, count).forEach {
            val input = readLine()!!
            numbers.add(input.split(SEPERATOR).map { it.toInt() })
        }

        return numbers
    }

    companion object {
        private const val SEPERATOR = ","
    }

}
