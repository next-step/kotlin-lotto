package lotto

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import org.junit.jupiter.params.provider.ValueSource

class LottoTest {
    @ParameterizedTest
    @ValueSource(ints = [0, -10, 46, 100])
    fun `로또 번호는 1보다 작거나 45보다 클수 없다`(number: Int) {
        shouldThrow<IllegalArgumentException> {
            LottoNumber(number)
        }.also {
            it.message shouldBe "로또 번호는 1보다 적거나 45보다 클 수 없습니다"
        }
    }

    @ParameterizedTest
    @MethodSource("providedDuplicationNumbers")
    fun `로또 티켓은 중복된 번호로 생성되면 예외가 발생한다`(numbers: List<Int>) {
        shouldThrow<IllegalArgumentException> {
            LottoTicket(numbers)
        }.also {
            it.message shouldBe "로또 티켓 번호가 잘못 입력되었습니다"
        }
    }

    @ParameterizedTest
    @MethodSource("providedWrongCountOfNumbers")
    fun `로또 티켓 번호는 6개가 아니면 예외가 발생한다`(numbers: List<Int>) {
        shouldThrow<IllegalArgumentException> {
            LottoTicket(numbers)
        }.also {
            it.message shouldBe "로또 티켓 번호가 잘못 입력되었습니다"
        }
    }

    @Test
    fun `로또 티켓은 한장 이상 구입 해야 한다`() {
        shouldThrow<IllegalArgumentException> {
            LottoTickets(listOf())
        }.also {
            it.message shouldBe "로또 티켓은 한장 이상 구입해야 합니다"
        }
    }

    @Test
    fun `로또 티켓을 구입 금액에 맞게 발급한다`() {
        val amount = 5_000
        val lottoTickets = LottoTickets.purchase(amount)
        lottoTickets.tickets.size shouldBe 5
    }

    @Test
    fun `로또 티켓을 생성하면 6개의 번호가 들어있다`() {
        val lottoTicket = LottoTicket.generateLottoNumber()
        lottoTicket.lottoNumbers.size shouldBe 6
    }

    companion object {
        @JvmStatic
        fun providedDuplicationNumbers() =
            listOf(
                Arguments.arguments(listOf(1, 1, 2, 3, 4, 5)),
                Arguments.arguments(listOf(5, 5, 12, 13, 34, 35)),
                Arguments.arguments(listOf(11, 19, 24, 33, 44, 44)),
            )

        @JvmStatic
        fun providedWrongCountOfNumbers() =
            listOf(
                Arguments.arguments(listOf(1, 2, 3, 4, 5, 6, 7)),
                Arguments.arguments(listOf(3, 5, 7, 8, 9)),
                Arguments.arguments(listOf(1, 1, 2, 2, 3, 3, 4, 4, 5, 5, 6, 6)),
            )
    }
}

data class LottoNumber(val number: Int) {
    init {
        require(number in 1..45) { "로또 번호는 1보다 적거나 45보다 클 수 없습니다" }
    }
}

class LottoTicket(numbers: List<Int>) {
    private val _lottoNumbers: Set<Int>
    val lottoNumbers: Set<Int>
        get() = _lottoNumbers.toSet()

    init {
        require(numbers.size == 6 && numbers.toSet().size == 6) { "로또 티켓 번호가 잘못 입력되었습니다" }
        _lottoNumbers = numbers.toSortedSet()
    }

    companion object {
        fun generateLottoNumber(): LottoTicket {
            val lottoNumbers =
                (1..45) // .map { LottoNumber(it.first) }
                    .shuffled()
                    .take(6)
            return LottoTicket(lottoNumbers)
        }
    }
}

class LottoTickets(lottoTickets: List<LottoTicket>) : Iterable<LottoTicket> {
    private val _tickets: List<LottoTicket>
    val tickets: List<LottoTicket>
        get() = _tickets

    init {
        require(lottoTickets.isNotEmpty()) { "로또 티켓은 한장 이상 구입해야 합니다" }
        _tickets = lottoTickets
    }

    override fun iterator(): Iterator<LottoTicket> {
        return _tickets.iterator()
    }

    companion object {
        fun purchase(amount: Int): LottoTickets {
            val quantity = amount / 1000
            var lottoTickets = ArrayList<LottoTicket>()
            repeat(quantity) {
                lottoTickets.add(LottoTicket.generateLottoNumber())
            }
            return LottoTickets(lottoTickets)
        }
    }
}
