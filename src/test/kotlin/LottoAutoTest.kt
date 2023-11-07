import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import lotto.LottoSimulator
import lotto.domain.LottoNumber
import lotto.domain.LottoTicket
import lotto.domain.LottoTickets
import lotto.domain.WinningNumber
import lotto.provider.budget.MockBudgetProvider
import lotto.provider.ticket.AutoTicketProvider
import lotto.provider.ticket.ManualTicketProvideStrategy
import lotto.provider.ticket.MockTicketProvider
import lotto.provider.winningnumber.MockWinningNumberProvider
import lotto.view.MockInputView
import lotto.view.ResultView
import org.assertj.core.api.Assertions.assertThatThrownBy
import java.lang.IllegalArgumentException

class LottoAutoTest : StringSpec({
    "each lotto ticket number not in 1..45 should throw IllegalArgumentException" {
        assertThatThrownBy {
            LottoNumber(0)
        }.isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("Invalid number")

        assertThatThrownBy {
            LottoNumber(50)
        }.isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("Invalid number")

        assertThatThrownBy {
            LottoNumber(-4)
        }.isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("Invalid number")
    }

    "lotto ticket should have exact 6 numbers else throw IllegalArgumentException" {
        assertThatThrownBy {
            LottoTicket(
                listOf(
                    LottoNumber(1),
                    LottoNumber(2),
                    LottoNumber(3),
                    LottoNumber(4),
                    LottoNumber(5),
                    LottoNumber(6),
                    LottoNumber(7),
                )
            )
        }.isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("Invalid size")

        assertThatThrownBy {
            LottoTicket(
                listOf(
                    LottoNumber(1),
                    LottoNumber(2),
                    LottoNumber(3),
                    LottoNumber(4),
                    LottoNumber(5),
                )
            )
        }.isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("Invalid size")
    }

    "lotto ticket with same numbers should throw IllegalArgumentException" {
        assertThatThrownBy {
            LottoTicket(
                listOf(
                    LottoNumber(1),
                    LottoNumber(2),
                    LottoNumber(3),
                    LottoNumber(4),
                    LottoNumber(5),
                    LottoNumber(5),
                )
            )
        }.isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("Duplicated number")

        assertThatThrownBy {
            LottoTicket(
                listOf(
                    LottoNumber(1),
                    LottoNumber(1),
                    LottoNumber(2),
                    LottoNumber(3),
                    LottoNumber(4),
                    LottoNumber(5),
                )
            )
        }.isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("Duplicated number")
    }

    "lotto ticket is 1,000 KRW/EA" {
        LottoSimulator(
            inputView = MockInputView(
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
            ),
            resultView = ResultView(),
        ).getTicketCount().shouldBe(1)
    }

    "should buy as many lotto tickets as possible with budget" {
        LottoSimulator(
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
            ),
            resultView = ResultView(),
        ).getTicketCount().shouldBe(1)

        LottoSimulator(
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
            ),
            resultView = ResultView(),
        ).getTicketCount().shouldBe(0)

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
                lottoTicketsProvider = AutoTicketProvider,
            ),
            resultView = ResultView(),
        ).getTicketCount().shouldBe(5)
    }

    "winning number should have exact 6 numbers else throw IllegalArgumentException" {
        assertThatThrownBy {
            WinningNumber(
                listOf(1, 2, 3, 4, 5)
                    .map { LottoNumber(it) }
            )
        }.isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("Invalid Winning number size")

        assertThatThrownBy {
            WinningNumber(
                listOf(1, 2, 3, 4, 5, 6, 7)
                    .map { LottoNumber(it) }
            )
        }.isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("Invalid Winning number size")
    }

    "winning number with same number should throw IllegalArgumentException" {
        assertThatThrownBy {
            WinningNumber(
                listOf(1, 2, 3, 4, 5, 5)
                    .map { LottoNumber(it) }
            )
        }.isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("Duplicated winning number")
    }

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
        ).simulate().profit.shouldBe(2_000_000_000)
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
