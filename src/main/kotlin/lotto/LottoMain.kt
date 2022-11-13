package lotto

import lotto.domain.LottoGame
import lotto.domain.LottoTicket
import lotto.domain.WinnerTicket
import lotto.dto.TICKET_PRICE
import lotto.util.LottoNumberGenerator
import java.lang.IllegalArgumentException

class LottoMain {
}

fun main() {
    println("구입금액을 입력해 주세요.")
    val amount: Int = readLine()?.toInt() ?: throw IllegalArgumentException("1000 이상의 숫자를 입력해주세요")
    val purchaseCount = amount / TICKET_PRICE
    require(purchaseCount > 0)
    println("${purchaseCount}개를 구매했습니다.")
    val lottoNumberList = (1..purchaseCount).map { LottoNumberGenerator.generateNumbers() }
    lottoNumberList.forEach { println(it.joinToString(separator = ", ", prefix = "[", postfix = "]")) }
    println("지난 주 당첨 번호를 입력해 주세요.")
    val winnerNumber = readLine()?.split(", ")
        ?.map { it.toInt() }
        ?.toSet() ?: throw IllegalArgumentException("당첨 번호는 , 를 기준으로 6자리 숫자를 입력해주세요.")
    val lottoGame = LottoGame(
        lottoTickets = lottoNumberList.map { LottoTicket.of(it) },
        winnerTicket = WinnerTicket.of(winnerNumber)
    )
    val winnerTickets = lottoGame.pickWinnerTickets()
    println("당첨 통계")
    println("---------")
    winnerTickets.statistics()
        .forEach { println("${it.lottoResult.matchCount}개 일치 (${it.lottoResult.winningMoney}원)- ${it.count}개") }
    println("총 수익률은 ${winnerTickets.calculateProfitRate()}입니다.")
}