package lotto

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import lotto.domain.LottoNumber
import lotto.domain.LottoTicket
import lotto.domain.LottoTickets
import lotto.domain.WinningNumber
import lotto.provider.budget.MockBudgetProvider
import lotto.provider.ticket.ManualTicketProvideStrategy
import lotto.provider.ticket.MockTicketProvider
import lotto.provider.winningnumber.MockWinningNumberProvider
import lotto.view.MockInputView
import lotto.view.ResultView

class LottoAutoTest : StringSpec({

    "winning statistics should calculate correct profit" {
        LottoSimulator(
            MockInputView(
                budgetProvider = MockBudgetProvider(5000),
                winningNumberProvider = MockWinningNumberProvider(
                    WinningNumber(
                        listOf(
                            LottoNumber(1),
                            LottoNumber(2),
                            LottoNumber(3),
                            LottoNumber(4),
                            LottoNumber(5),
                            LottoNumber(6),
                        )
                    )
                ),
                lottoTicketsProvider = MockTicketProvider(
                    ManualTicketProvideStrategy(
                        LottoTickets(
                            listOf(
                                LottoTicket(listOf(1, 2, 3, 4, 5, 6).map { LottoNumber(it) })
                            )
                        )
                    )
                ),
            ),
            resultView = ResultView(),
        ).simulate().lottoProfitResult.totalPrize shouldBe 2_000_000_000
    }

    "winning statistics should show correct ROI" {
        LottoSimulator(
            MockInputView(
                budgetProvider = MockBudgetProvider(5000),
                winningNumberProvider = MockWinningNumberProvider(
                    WinningNumber(
                        listOf(
                            LottoNumber(1),
                            LottoNumber(2),
                            LottoNumber(3),
                            LottoNumber(4),
                            LottoNumber(5),
                            LottoNumber(6),
                        )
                    )
                ),
                lottoTicketsProvider = MockTicketProvider(
                    ManualTicketProvideStrategy(
                        LottoTickets(
                            listOf(
                                LottoTicket(listOf(1, 2, 3, 4, 5, 6).map { LottoNumber(it) })
                            )
                        )
                    )
                ),
            ),
            resultView = ResultView(),
        ).simulate().profitRate.shouldBe(400_000)
    }
})
