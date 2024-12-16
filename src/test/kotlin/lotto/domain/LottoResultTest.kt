package lotto.domain

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class LottoResultTest {
    @ParameterizedTest
    @MethodSource("generate1stTicket")
    fun `1등 당첨되었는지 확인한다`(
        tickets: List<LottoTicket>,
        winTicket: LottoTicket,
        count: Int,
    ) {
        val result = LottoResult(tickets, winTicket, tickets.size)
        result.first shouldBe count
    }

    @ParameterizedTest
    @MethodSource("generate2ndTicket")
    fun `2등 당첨되었는지 확인한다`(
        tickets: List<LottoTicket>,
        winTicket: LottoTicket,
        count: Int,
    ) {
        val result = LottoResult(tickets, winTicket, tickets.size)
        result.second shouldBe count
    }

    @ParameterizedTest
    @MethodSource("generate3rdTicket")
    fun `3등 당첨되었는지 확인한다`(
        tickets: List<LottoTicket>,
        winTicket: LottoTicket,
        count: Int,
    ) {
        val result = LottoResult(tickets, winTicket, tickets.size)
        result.third shouldBe count
    }

    @ParameterizedTest
    @MethodSource("generate4thTicket")
    fun `4등 당첨되었는지 확인한다`(
        tickets: List<LottoTicket>,
        winTicket: LottoTicket,
        count: Int,
    ) {
        val result = LottoResult(tickets, winTicket, tickets.size)
        result.fourth shouldBe count
    }

    companion object {
        @JvmStatic
        fun generate1stTicket(): Stream<Arguments> {
            return Stream.of(
                Arguments.of(
                    listOf(makeLottoTicket(1, 2, 3, 4, 5, 6)),
                    makeLottoTicket(1, 2, 3, 4, 5, 6),
                    1,
                ),
            )
        }

        @JvmStatic
        fun generate2ndTicket(): Stream<Arguments> {
            return Stream.of(
                Arguments.of(
                    listOf(makeLottoTicket(1, 2, 3, 4, 5, 7)),
                    makeLottoTicket(1, 2, 3, 4, 5, 6),
                    1,
                ),
            )
        }

        @JvmStatic
        fun generate3rdTicket(): Stream<Arguments> {
            return Stream.of(
                Arguments.of(
                    listOf(makeLottoTicket(1, 2, 3, 4, 5, 6)),
                    makeLottoTicket(1, 2, 3, 4, 7, 8),
                    1,
                ),
            )
        }

        @JvmStatic
        fun generate4thTicket(): Stream<Arguments> {
            return Stream.of(
                Arguments.of(
                    listOf(makeLottoTicket(1, 2, 3, 4, 5, 6)),
                    makeLottoTicket(1, 2, 3, 7, 8, 9),
                    1,
                ),
            )
        }

        fun makeLottoTicket(vararg elements: Int): LottoTicket {
            return LottoTicket(elements.map { LottoNumber.from(it) })
        }
    }
}
