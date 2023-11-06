import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import org.assertj.core.api.Assertions.assertThatThrownBy
import java.lang.IllegalArgumentException

@JvmInline
value class LottoNumber(val value: Int) {
    init {
        require(value in 1..45) {
            throw IllegalArgumentException("Invalid number: number not in 1..45")
        }
    }
}

data class LottoTicket(private val lottoNumberList: List<LottoNumber>) {
    init {
        require(lottoNumberList.size == 6) {
            throw IllegalArgumentException("Invalid size: lotto numbers should have exact 6 numbers: $lottoNumberList")
        }
        require(lottoNumberList.toSet().size == 6) {
            throw IllegalArgumentException("Duplicated number: lotto numbers should not have duplicated number: $lottoNumberList")
        }
    }
}

data class LottoTickets(val lottoTicketList: List<LottoTicket>)

class LottoSimulator(
    private val inputView: InputView,
    private val lottoTicketsProvider: LottoTicketsProvider,
    private val resultView: ResultView,
) {
    fun getTicketCount(): Int {
        val budget = inputView.provideBudget()
        return budget / 1000
    }

    fun simulate() {
        val lottoTickets = lottoTicketsProvider.provideLottoTickets(getTicketCount())

        val winningNumbers = inputView.provideWinningNumbers()

        resultView.printResult(lottoTickets, winningNumbers)
    }
}

interface InputView {
    fun provideBudget(): Int

    fun provideWinningNumbers(): LottoTicket
}

class MockInputView(
    private val budget: Int,
    private val winningNumbers: LottoTicket,
) : InputView {
    override fun provideBudget(): Int = budget

    override fun provideWinningNumbers(): LottoTicket = winningNumbers
}

interface LottoTicketsProvider {
    fun provideLottoTickets(ticketCount: Int): LottoTickets
}

class ResultView {
    fun printResult(lottoTickets: LottoTickets, winningNumbers: LottoTicket) {
    }
}

object AutoProvider : LottoTicketsProvider {
    override fun provideLottoTickets(ticketCount: Int): LottoTickets {
        val tickets = mutableListOf<LottoTicket>()

        while (tickets.size != ticketCount) {
            val ticket = LottoTicket(
                (1..45)
                    .toMutableList()
                    .shuffled()
                    .subList(0, 6)
                    .map { LottoNumber(it) }
            )
            tickets.add(ticket)
        }

        return LottoTickets(tickets)
    }
}

data class WinningNumber(private val lottoNumberList: List<LottoNumber>) {
    init {
        require(lottoNumberList.size == 6) {
            throw IllegalArgumentException("Invalid Winning number size: winning number should have exact 6 numbers: $lottoNumberList")
        }
        require(lottoNumberList.toSet().size == 6) {
            throw IllegalArgumentException("Duplicated winning number: winning number should not have duplicated number: $lottoNumberList")
        }
    }
}

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
                winningNumbers = LottoTicket(
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
                budget = 1001,
                winningNumbers = LottoTicket(
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
                winningNumbers = LottoTicket(
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
                winningNumbers = LottoTicket(
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
    }

    "winning statistics should show correct ROI" {
    }
})
