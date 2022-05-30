package lotto

import lotto.domain.LottoPrizeManager
import lotto.domain.LottoPrizePolicy
import lotto.domain.Money
import lotto.domain.TicketSeller
import lotto.domain.WinningLottoNumbers
import lotto.dto.UserMoneyInputDto
import lotto.dto.WinningNumbersInputDto
import lotto.util.KotlinRandomGenerate
import lotto.view.BuyLottoInputView
import lotto.view.BuyLottoOutputView

fun main() {
    val lottoTicketPrice = Money(1000)
    val ticketSeller = TicketSeller(lottoTicketPrice, KotlinRandomGenerate)
    val lottoPrizeManager = LottoPrizeManager()
    lottoPrizeManager.addUniquePolicy(LottoPrizePolicy(3, Money(5000)))
    lottoPrizeManager.addUniquePolicy(LottoPrizePolicy(4, Money(50000)))
    lottoPrizeManager.addUniquePolicy(LottoPrizePolicy(5, Money(1500000), false))
    lottoPrizeManager.addUniquePolicy(LottoPrizePolicy(5, Money(30000000), true))
    lottoPrizeManager.addUniquePolicy(LottoPrizePolicy(6, Money(2000000000)))

    println(BuyLottoInputView.showUserMoneyInputGuide())
    val userMoneyInputDto = UserMoneyInputDto(readln())
    val boughtLottoTickets = ticketSeller.buyPossibleLottoTicket(userMoneyInputDto.userMoney)

    println(BuyLottoOutputView.showAllBoughtTickets(boughtLottoTickets))

    println(BuyLottoInputView.showWinningLottoNumbersInputGuide())
    val winningNumbersInputDto = WinningNumbersInputDto(readln())
    println()

    println(BuyLottoOutputView.showWinningStartLabel())

    // TODO 아래 변경
    val winningStats =
        lottoPrizeManager.getWinningStats(
            boughtLottoTickets,
            WinningLottoNumbers.ofInt(winningNumbersInputDto.winningLottoTicketNumbers.value.map { it.value }, 45)
        )
    println(BuyLottoOutputView.showAllWinningStat(winningStats))
    println(BuyLottoOutputView.showEarningsRate(Money(boughtLottoTickets.size * lottoTicketPrice.value), winningStats))
}
