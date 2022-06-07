package lotto

import lotto.domain.LottoCommittee
import lotto.domain.LottoMarket
import lotto.view.Screen

fun main() {
    try {
        println("구입금액을 입력해 주세요.")
        val price = readln().toInt()

        println("수동으로 구매할 로또 수를 입력해 주세요.")
        val manualAmount = readln().toInt()

        val manualInputs = mutableListOf<String>()
        println("수동으로 구매할 번호를 입력해 주세요.")
        repeat(manualAmount) {
            manualInputs.add(readln())
        }

        val lottos = LottoMarket.buy(price, manualInputs)

        Screen.displayTicketInfo(lottos, manualInputs.size)

        println("지난 주 당첨 번호를 입력해 주세요.")
        val winningInput = readln()

        println("보너스 볼을 입력해 주세요.")
        val bonusBall = readln()

        val winningTicket = LottoCommittee.createWinningTicket(winningInput, bonusBall)
        val statistics = LottoCommittee.calculateStatistics(lottos, winningTicket)

        Screen.display(
            statistics,
            LottoCommittee.calculateReturnRate(price, statistics)
        )
    } catch (e: Exception) {
        when (e) {
            is NumberFormatException -> { println("숫자가 아닌 값이 들어왔습니다") }
            is IllegalArgumentException -> { println(e) }
            else -> { println("예상치 못한 예외가 발생했습니다. $e") }
        }
    }
}
