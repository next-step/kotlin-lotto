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

data class LottoTicket(private var _lottoNumberList: List<LottoNumber>) {
    val lottoNumberList get() = _lottoNumberList

    init {
        require(_lottoNumberList.size == 6) {
            throw IllegalArgumentException("Invalid size: lotto numbers should have exact 6 numbers: $lottoNumberList")
        }
        require(_lottoNumberList.toSet().size == 6) {
            throw IllegalArgumentException("Duplicated number: lotto numbers should not have duplicated number: $lottoNumberList")
        }
        _lottoNumberList = _lottoNumberList.sortedBy { it.value }
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
        return budget / lottoTicketsProvider.provideLottoPrice()
    }

    fun getTicketPrice(): Int = lottoTicketsProvider.provideLottoPrice() * getTicketCount()

    fun simulate(): LottoResult {
        val lottoTickets = lottoTicketsProvider.provideLottoTickets(getTicketCount())
        val winningNumbers = inputView.provideWinningNumbers()
        val result = resultView.getResult(
            lottoTickets,
            winningNumbers,
            getTicketPrice(),
            inputView.provideBudget() - getTicketPrice()
        )
        resultView.printResult(result)
        return result
    }
}

interface InputView {
    fun provideBudget(): Int

    fun provideWinningNumbers(): WinningNumber
}

class MockInputView(
    private val budget: Int,
    private val winningNumber: WinningNumber,
) : InputView {
    override fun provideBudget(): Int = budget

    override fun provideWinningNumbers(): WinningNumber = winningNumber
}

interface LottoTicketsProvider {
    fun provideLottoTickets(ticketCount: Int): LottoTickets

    fun provideLottoPrice(): Int
}

object ResultProvider {
    fun provideLottoResult(
        lottoTickets: LottoTickets,
        winningNumber: WinningNumber,
        ticketPrice: Int,
        remainder: Int
    ): LottoResult {
        val result = mutableMapOf(
            (Rank.ThreeHit to 0),
            (Rank.FourHit to 0),
            (Rank.FiveHit to 0),
            (Rank.SixHit to 0),
        )

        lottoTickets.lottoTicketList.forEach { lottoTicket ->
            val hitCount = winningNumber.getHitCount(lottoTicket)
            if (Rank.values().map { it.hitCount }.contains(hitCount)) {
                val rank = Rank.values().find { it.hitCount == hitCount } ?: return@forEach
                result[rank]?.plus(1)
            }
        }

        var profit = 0

        Rank.values().forEach { rank ->
            profit += rank.hitCount * rank.prize
        }

        val profitRate = String.format("%.2f", profit.toDouble() / ticketPrice.toDouble()).toDouble()

        return LottoResult(
            profit,
            ticketPrice,
            remainder,
            profitRate,
            result
        )
    }
}

data class LottoResult(
    val profit: Int,
    val netSpent: Int,
    val remainder: Int,
    val profitRate: Double,
    val rankResult: Map<Rank, Int>
)

class ResultView(private val resultProvider: ResultProvider = ResultProvider) {

    fun getResult(
        lottoTickets: LottoTickets,
        winningNumber: WinningNumber,
        ticketPrice: Int,
        remainder: Int
    ): LottoResult = resultProvider.provideLottoResult(lottoTickets, winningNumber, ticketPrice, remainder)

    fun printResult(lottoResult: LottoResult) {

        var profit = 0

        Rank.values().forEach { rank ->
            println("${rank.hitCount}개 일치 (${rank.prize}원)- ${lottoResult.rankResult[rank]}개")
            profit += rank.hitCount * rank.prize
        }

        val profitRate = String.format("%.2f", profit.toDouble() / lottoResult.netSpent.toDouble()).toDouble()

        println("총 수익률은 $profitRate 입니다.")
    }
}

enum class Rank(val hitCount: Int, val prize: Int) {
    ThreeHit(3, 5_000),
    FourHit(4, 50_000),
    FiveHit(5, 1_500_000),
    SixHit(6, 2_000_000_000),
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

    override fun provideLottoPrice(): Int = 1000
}

data class WinningNumber(private var _lottoNumberList: List<LottoNumber>) {
    val lottoNumberList get() = _lottoNumberList

    init {
        require(_lottoNumberList.size == 6) {
            throw IllegalArgumentException("Invalid Winning number size: winning number should have exact 6 numbers: $lottoNumberList")
        }
        require(_lottoNumberList.toSet().size == 6) {
            throw IllegalArgumentException("Duplicated winning number: winning number should not have duplicated number: $lottoNumberList")
        }
        _lottoNumberList = _lottoNumberList.sortedBy { it.value }
    }

    fun getHitCount(lottoTicket: LottoTicket): Int {
        var hitCount = 0

        lottoTicket.lottoNumberList.forEach {
            if (lottoNumberList.contains(it)) {
                hitCount += 1
            }
        }
        return hitCount
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
