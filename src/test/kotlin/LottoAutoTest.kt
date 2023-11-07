import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import lotto.LottoSimulator
import lotto.domain.LottoNumber
import lotto.domain.LottoTicket
import lotto.domain.WinningNumber
import lotto.provider.ticket.AutoProvider
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
                budget = 1000,
                winningNumber = WinningNumber(
                    listOf(
                        LottoNumber(1),
                        LottoNumber(2),
                        LottoNumber(3),
                        LottoNumber(4),
                        LottoNumber(5),
                        LottoNumber(6),
                    )
                ),
            ),
            lottoTicketsProvider = AutoProvider,
            resultView = ResultView(),
        ).getTicketCount().shouldBe(1)
    }

    "should buy as many lotto tickets as possible with budget" {
        LottoSimulator(
            MockInputView(
                budget = 1000,
                winningNumber = WinningNumber(
                    listOf(
                        LottoNumber(1),
                        LottoNumber(2),
                        LottoNumber(3),
                        LottoNumber(4),
                        LottoNumber(5),
                        LottoNumber(6),
                    )
                ),
            ),
            lottoTicketsProvider = AutoProvider,
            resultView = ResultView(),
        ).getTicketCount().shouldBe(1)

        LottoSimulator(
            MockInputView(
                budget = 300,
                winningNumber = WinningNumber(
                    listOf(
                        LottoNumber(1),
                        LottoNumber(2),
                        LottoNumber(3),
                        LottoNumber(4),
                        LottoNumber(5),
                        LottoNumber(6),
                    )
                ),
            ),
            lottoTicketsProvider = AutoProvider,
            resultView = ResultView(),
        ).getTicketCount().shouldBe(0)

        LottoSimulator(
            MockInputView(
                budget = 5000,
                winningNumber = WinningNumber(
                    listOf(
                        LottoNumber(1),
                        LottoNumber(2),
                        LottoNumber(3),
                        LottoNumber(4),
                        LottoNumber(5),
                        LottoNumber(6),
                    )
                ),
            ),
            lottoTicketsProvider = AutoProvider,
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

    "winning statistics should show correct win state" {
        LottoSimulator(
            MockInputView(
                budget = 5000,
                winningNumber = WinningNumber(
                    listOf(
                        LottoNumber(1),
                        LottoNumber(2),
                        LottoNumber(3),
                        LottoNumber(4),
                        LottoNumber(5),
                        LottoNumber(6),
                    )
                ),
            ),
            lottoTicketsProvider = AutoProvider,
            resultView = ResultView(),
        ).simulate()
    }

    "winning statistics should show correct ROI" {
    }
})
