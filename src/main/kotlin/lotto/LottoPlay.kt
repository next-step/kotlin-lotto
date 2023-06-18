package lotto

import lotto.model.Lotto
import lotto.service.LottoPlayResultAnalysis
import lotto.service.LottoTicketCountCalculator


fun main() {
    println("구매 금액을 입력해주세요.")
    val purchaseAmount = readLine()!!.toInt()
    val ticketCount = LottoTicketCountCalculator.getCount(purchaseAmount)
    println("$ticketCount 개를 구매했습니다.")

    val winningLottos: MutableList<Lotto> = mutableListOf()
    repeat(ticketCount) {
        val winningLotto = Lotto()
        winningLottos.add(winningLotto)
        println(winningLotto.winningNumber.toString())
    }

    println("지난 주 당첨 번호를 입력해 주세요.")
    val lastWeekWinningString = readLine()
    val lastWeekWinningNumbers: List<Int> = lastWeekWinningString?.split(",")?.map { it.trim().toInt() } ?: emptyList()

    winningLottos.forEach { it.setLottoPrize(lastWeekWinningNumbers) }

    LottoPlayResultAnalysis.printResult(winningLottos, purchaseAmount)
}
