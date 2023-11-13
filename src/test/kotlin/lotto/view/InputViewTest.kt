package lotto.view

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import lotto.domain.LottoNumber
import lotto.domain.WinningNumber
import lotto.provider.budget.MockBudgetProvider
import lotto.provider.ticket.AutoTicketProvider
import lotto.provider.winningnumber.MockWinningNumberProvider

class InputViewTest : StringSpec({
    "lotto ticket is 1,000 KRW/EA" {
        MockInputView(
            budgetProvider = MockBudgetProvider(1000),
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
            lottoTicketsProvider = AutoTicketProvider,
        ).provideTicketCount().shouldBe(1)
    }

    "should buy as many lotto tickets as possible with budget" {
        MockInputView(
            budgetProvider = MockBudgetProvider(1000),
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
            lottoTicketsProvider = AutoTicketProvider
        ).provideTicketCount().shouldBe(1)

        MockInputView(
            budgetProvider = MockBudgetProvider(300),
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
            lottoTicketsProvider = AutoTicketProvider,
        ).provideTicketCount().shouldBe(0)

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
            lottoTicketsProvider = AutoTicketProvider,
        ).provideTicketCount().shouldBe(5)
    }
})
