package lotto

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import lotto.domain.LottoNumber
import lotto.domain.LottoTicket
import lotto.domain.Rank
import lotto.domain.WinningNumber
import lotto.generator.MockLottoShop
import lotto.generator.ticket.ManualTicketGenerator
import lotto.view.MockInputView
import lotto.view.ResultView

class LottoAutoTest : StringSpec({

    "winning statistics should calculate correct profit" {
        LottoSimulator(
            inputView = MockInputView(
                budget = 1000,
                winningNumber = WinningNumber(
                    LottoTicket(listOf(1, 2, 3, 4, 5, 6).map { LottoNumber(it) }),
                    bonusNumber = LottoNumber(19)
                ),
                manualNumbersList = listOf(listOf(1, 2, 3, 4, 5, 6))
            ),
            resultView = ResultView(),
        ).simulate(
            lottoShop = MockLottoShop(
                manualTicketGenerator = ManualTicketGenerator
            )
        ).totalPrize shouldBe Rank.FirstPlace.prize
    }

    "winning statistics should show correct ROI" {
        LottoSimulator(
            inputView = MockInputView(
                budget = 1000,
                winningNumber = WinningNumber(
                    LottoTicket(listOf(1, 2, 3, 4, 5, 6).map { LottoNumber(it) }),
                    bonusNumber = LottoNumber(19)
                ),
                manualNumbersList = listOf(listOf(1, 2, 3, 4, 5, 6))
            ),
            resultView = ResultView(),
        ).simulate(
            lottoShop = MockLottoShop(
                manualTicketGenerator = ManualTicketGenerator
            ),
        ).profitRate.shouldBe(2_000_000)
    }

    "second place result should be correct" {
        LottoSimulator(
            inputView = MockInputView(
                budget = 1000,
                winningNumber = WinningNumber(
                    LottoTicket(listOf(1, 2, 3, 4, 5, 9).map { LottoNumber(it) }),
                    bonusNumber = LottoNumber(19)
                ),
                manualNumbersList = listOf(listOf(1, 2, 3, 4, 5, 19))
            ),
            resultView = ResultView(),
        ).simulate(
            lottoShop = MockLottoShop(
                manualTicketGenerator = ManualTicketGenerator
            ),
        ).totalPrize shouldBe Rank.SecondPlace.prize
    }
})
