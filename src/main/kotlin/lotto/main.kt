package lotto

import lotto.domain.LottoPrizePolicy
import lotto.domain.LottoTicket
import lotto.domain.Money
import lotto.dto.UserMoneyInputDto
import lotto.dto.WinningNumbersInputDto

fun main() {
    val lottoTicketPrice = Money(1000)

    println("구입금액을 입력해 주세요.")
    val userMoneyInputDto = UserMoneyInputDto(readln())
    val buyTicketCount = userMoneyInputDto.userMoney.value / lottoTicketPrice.value
    val buyLottoTickets = mutableListOf<LottoTicket>()

    repeat(buyTicketCount) {
        buyLottoTickets.add(LottoTicket.ofInts((1..45).shuffled().take(6)))
    }
    println()
    println("${buyTicketCount}를 구매했습니다")
    buyLottoTickets.forEach {
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
        val prizeCount = buyLottoTickets.count { lottoPrizePolicy.won(it) != null }
        totalPrize += lottoPrizePolicy.wonPrize.value * prizeCount
        println("${lottoPrizePolicy.wonMatchedCount}개 일치 (${lottoPrizePolicy.wonPrize.value})-${prizeCount}개")
    }
    val earningsRate: Double = totalPrize.toDouble() / (buyTicketCount * lottoTicketPrice.value)
    println(
        "총 수익률은 ${
        String.format("%.1f", earningsRate)
        }입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)"
    )
}
