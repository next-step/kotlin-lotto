package lotto.domain

import io.kotest.assertions.throwables.shouldThrowWithMessage
import lotto.domain.LottoTicket.Companion.INVALID_LOTTO_NUMBER_COUNT_MESSAGE
import lotto.domain.LottoTicket.Companion.INVALID_WINNER_NUMBERS_RANGE_MESSAGE
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class LottoTicketTest {
    @MethodSource("7개 이상, 또는 6개 미만의 숫자 제공")
    @ParameterizedTest
    fun `로또 번호는 숫자 6개가 아니면 에러가 발생한다`(numberSet: Set<Int>) {
        shouldThrowWithMessage<IllegalArgumentException>(message = INVALID_LOTTO_NUMBER_COUNT_MESSAGE) {
            LottoTicket(generateLottoNumbers = { numberSet })
        }
    }

    fun `7개 이상, 또는 6개 미만의 숫자 제공`(): Stream<Arguments> {
        return Stream.of(
            Arguments.of(setOf(5, 11, 15, 16, 17, 18, 19)),
            Arguments.of(setOf(4, 5, 6, 7)),
            Arguments.of(setOf(15, 16, 17, 18, 19)),
        )
    }

    @MethodSource("1미만 46 이상의 숫자가 있는 로또 번호 제공")
    @ParameterizedTest
    fun `로또 번호는 1부터 45사이의 숫자가 아니면 에러가 발생한다`(numberSet: Set<Int>) {
        shouldThrowWithMessage<IllegalArgumentException>(message = INVALID_WINNER_NUMBERS_RANGE_MESSAGE) {
            LottoTicket(generateLottoNumbers = { numberSet })
        }
    }

    fun `1미만 46 이상의 숫자가 있는 로또 번호 제공`(): Stream<Arguments> {
        return Stream.of(
            Arguments.of(setOf(0, 11, 15, 1, 2, 3)),
            Arguments.of(setOf(14, 15, 46, 7, 4, 5)),
            Arguments.of(setOf(15, 16, 17, 18, -3, 1)),
        )
    }
}
