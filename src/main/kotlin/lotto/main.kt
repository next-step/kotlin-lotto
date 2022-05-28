package lotto

import lotto.domain.LottoPrizePolicy
import lotto.domain.Money
import lotto.domain.TicketSeller
import lotto.dto.UserMoneyInputDto
import lotto.dto.WinningNumbersInputDto
import lotto.util.KotlinRandomGenerate

fun main() {
    val lottoTicketPrice = Money(1000)
    val ticketSeller = TicketSeller(lottoTicketPrice, KotlinRandomGenerate)

    println("구입금액을 입력해 주세요.")
    val userMoneyInputDto = UserMoneyInputDto(readln())
    val boughtLottoTickets = ticketSeller.buyPossibleLottoTicket(userMoneyInputDto.userMoney)

    println()
    println("${boughtLottoTickets}를 구매했습니다")
    boughtLottoTickets.forEach {
        println(it.lottoTicketNumbers.value.map { it.value }.sorted().joinToString(prefix = "[", postfix = "]"))
    }

    println()
    println("지난 주 당첨 번호를 입력해 주세요.")
    val winningNumbersInputDto = WinningNumbersInputDto(readln())

    println()
    println("당첨통계")
    println("---------")
    val lottoPrizePolicyList = listOf(
        LottoPrizePolicy(3, winningNumbersInputDto.winningLottoTicketNumbers, Money(5000)),
        LottoPrizePolicy(4, winningNumbersInputDto.winningLottoTicketNumbers, Money(50000)),
        LottoPrizePolicy(5, winningNumbersInputDto.winningLottoTicketNumbers, Money(1500000)),
        LottoPrizePolicy(6, winningNumbersInputDto.winningLottoTicketNumbers, Money(2000000000))
    )

    var totalPrize = 0
    lottoPrizePolicyList.forEach { lottoPrizePolicy ->
        val prizeCount = boughtLottoTickets.count { lottoPrizePolicy.won(it) != null }
        totalPrize += lottoPrizePolicy.wonPrize.value * prizeCount
        println("${lottoPrizePolicy.wonMatchedCount}개 일치 (${lottoPrizePolicy.wonPrize.value})-${prizeCount}개")
    }
    val earningsRate: Double = totalPrize.toDouble() / (boughtLottoTickets.size * lottoTicketPrice.value)
    println(
        "총 수익률은 ${
        String.format("%.1f", earningsRate)
        }입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)"
    )
}
