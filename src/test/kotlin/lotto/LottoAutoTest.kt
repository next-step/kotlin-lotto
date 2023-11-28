package lotto

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import lotto.domain.LottoNumber
import lotto.domain.LottoTicket
import lotto.domain.LottoTickets
import lotto.domain.ManualTicketProvideStrategy
import lotto.domain.Rank
import lotto.domain.WinningNumber
import lotto.provider.ticket.MockTicketProvider
import lotto.view.MockInputView
import lotto.view.ResultView

class LottoAutoTest : StringSpec({

    "winning statistics should calculate correct profit" {
        LottoSimulator(
            MockInputView(
                budget = 5000,
                winningNumber = WinningNumber(
                    LottoTicket(listOf(1, 2, 3, 4, 5, 6).map { LottoNumber(it) }),
                    bonusNumber = LottoNumber(19)
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
        ).simulate().lottoProfitResult.totalPrize shouldBe Rank.FirstPlace.prize
    }

    "winning statistics should show correct ROI" {
        LottoSimulator(
            MockInputView(
                budget = 5000,
                winningNumber = WinningNumber(
                    LottoTicket(listOf(1, 2, 3, 4, 5, 6).map { LottoNumber(it) }),
                    bonusNumber = LottoNumber(19)
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

    "second place result should be correct" {
        LottoSimulator(
            MockInputView(
                budget = 5000,
                winningNumber = WinningNumber(
                    LottoTicket(listOf(1, 2, 3, 4, 5, 9).map { LottoNumber(it) }),
                    bonusNumber = LottoNumber(19)
                ),
                lottoTicketsProvider = MockTicketProvider(
                    ManualTicketProvideStrategy(
                        LottoTickets(
                            listOf(
                                LottoTicket(listOf(1, 2, 3, 4, 5, 19).map { LottoNumber(it) })
                            )
                        )
                    )
                ),
            ),
            resultView = ResultView(),
        ).simulate().lottoProfitResult.totalPrize shouldBe Rank.SecondPlace.prize
    }
})
