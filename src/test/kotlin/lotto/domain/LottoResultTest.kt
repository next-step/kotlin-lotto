package lotto.domain

import io.kotest.matchers.shouldBe
import lotto.domain.LottoWinnerTest.Companion.DEFAULT_LOTTO_WINNER
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class LottoResultTest {
    @ParameterizedTest
    @MethodSource("generate1stTicket")
    fun `1등 당첨 횟수 확인한다`(tickets: List<LottoTicket>) {
        val result = LottoResult(tickets, DEFAULT_LOTTO_WINNER, tickets.size)
        result.first shouldBe tickets.size
    }

    @ParameterizedTest
    @MethodSource("generate2ndTicket")
    fun `2등 당첨되었는지 확인한다`(tickets: List<LottoTicket>) {
        val result = LottoResult(tickets, DEFAULT_LOTTO_WINNER, tickets.size)
        result.second shouldBe tickets.size
    }

    @ParameterizedTest
    @MethodSource("generate3rdTicket")
    fun `3등 당첨되었는지 확인한다`(tickets: List<LottoTicket>) {
        val result = LottoResult(tickets, DEFAULT_LOTTO_WINNER, tickets.size)
        result.third shouldBe tickets.size
    }

    @ParameterizedTest
    @MethodSource("generate4thTicket")
    fun `4등 당첨되었는지 확인한다`(tickets: List<LottoTicket>) {
        val result = LottoResult(tickets, DEFAULT_LOTTO_WINNER, tickets.size)
        result.fourth shouldBe tickets.size
    }

    @ParameterizedTest
    @MethodSource("generate5thTicket")
    fun `5등 당첨되었는지 확인한다`(tickets: List<LottoTicket>) {
        val result = LottoResult(tickets, DEFAULT_LOTTO_WINNER, tickets.size)
        result.fifth shouldBe tickets.size
    }

    companion object {
        @JvmStatic
        fun generate1stTicket(): Stream<Arguments> {
            return Stream.of(
                Arguments.of(
                    listOf(
                        makeLottoTicket(1, 2, 3, 4, 5, 6),
                        makeLottoTicket(1, 2, 3, 4, 5, 6),
                    ),
                ),
            )
        }

        @JvmStatic
        fun generate2ndTicket(): Stream<Arguments> {
            return Stream.of(
                Arguments.of(
                    listOf(
                        makeLottoTicket(10, 2, 3, 4, 5, 6),
                        makeLottoTicket(1, 10, 3, 4, 5, 6),
                        makeLottoTicket(1, 2, 3, 4, 10, 6),
                        makeLottoTicket(1, 2, 3, 4, 5, 10),
                    ),
                ),
            )
        }

        @JvmStatic
        fun generate3rdTicket(): Stream<Arguments> {
            return Stream.of(
                Arguments.of(
                    listOf(
                        makeLottoTicket(1, 2, 3, 4, 5, 7),
                        makeLottoTicket(1, 2, 3, 4, 8, 6),
                        makeLottoTicket(1, 2, 3, 9, 5, 6),
                        makeLottoTicket(1, 45, 3, 4, 5, 6),
                    ),
                ),
            )
        }

        @JvmStatic
        fun generate4thTicket(): Stream<Arguments> {
            return Stream.of(
                Arguments.of(
                    listOf(
                        makeLottoTicket(11, 21, 3, 4, 5, 6),
                        makeLottoTicket(1, 2, 33, 44, 5, 6),
                        makeLottoTicket(1, 2, 13, 4, 25, 6),
                        makeLottoTicket(1, 32, 3, 4, 5, 26),
                    ),
                ),
            )
        }

        @JvmStatic
        fun generate5thTicket(): Stream<Arguments> {
            return Stream.of(
                Arguments.of(
                    listOf(
                        makeLottoTicket(11, 21, 31, 4, 5, 6),
                        makeLottoTicket(1, 23, 33, 42, 5, 6),
                        makeLottoTicket(1, 2, 3, 41, 25, 36),
                        makeLottoTicket(1, 27, 39, 41, 5, 6),
                    ),
                ),
            )
        }

        private fun makeLottoTicket(vararg elements: Int): LottoTicket {
            return LottoTicket(elements.map { LottoNumber.from(it) })
        }
    }
}
