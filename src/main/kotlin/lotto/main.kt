package lotto

import lotto.domain.LottoPrizeManager
import lotto.domain.LottoPrizePolicy
import lotto.domain.Money
import lotto.domain.TicketSeller
import lotto.domain.WinningLottoNumbers
import lotto.util.KotlinRandomGenerate
import lotto.util.KotlinStandardInputModule
import lotto.util.KotlinStandardOutPutModule
import lotto.view.BuyLottoInputView
import lotto.view.BuyLottoOutputView

fun main() {
    val lottoTicketPrice = Money(1000)
    val ticketSeller = TicketSeller(lottoTicketPrice, KotlinRandomGenerate)
    val lottoPrizeManager = LottoPrizeManager()
    val buyLottoOutputView = BuyLottoOutputView(KotlinStandardOutPutModule)
    val buyLottoInputView = BuyLottoInputView(KotlinStandardInputModule, KotlinStandardOutPutModule)
    lottoPrizeManager.addUniquePolicy(LottoPrizePolicy(3, Money(5000)))
    lottoPrizeManager.addUniquePolicy(LottoPrizePolicy(4, Money(50000)))
    lottoPrizeManager.addUniquePolicy(LottoPrizePolicy(5, Money(1500000), false))
    lottoPrizeManager.addUniquePolicy(LottoPrizePolicy(5, Money(30000000), true))
    lottoPrizeManager.addUniquePolicy(LottoPrizePolicy(6, Money(2000000000)))

    val userMoneyInputDto = buyLottoInputView.readUserMoneyInput()
    val boughtLottoTickets = ticketSeller.buyPossibleLottoTicket(userMoneyInputDto.userMoney)

    buyLottoOutputView.showAllBoughtTickets(boughtLottoTickets)

    val winningNumbersInputDto = buyLottoInputView.readWinningLottoNumbers()

    buyLottoOutputView.showTotalWinningInformation(
        Money(boughtLottoTickets.size * lottoTicketPrice.value),
        lottoPrizeManager.getWinningStats(
            boughtLottoTickets,
            WinningLottoNumbers.ofInt(winningNumbersInputDto.winningLottoTicketNumbers.value.map { it.value }, 45)
        )
    )
}
