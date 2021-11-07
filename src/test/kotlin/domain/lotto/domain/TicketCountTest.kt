package domain.lotto.domain

import domain.lotto.error.InvalidTicketCountRangeException
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.RepeatedTest
import org.junit.jupiter.api.RepetitionInfo
import org.junit.jupiter.api.assertAll
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.ValueSource

@DisplayName("로또티켓(Ticket)")
class TicketCountTest {

    @RepeatedTest(value = 100, name = "현재, {currentRepetition}/{totalRepetitions}")
    fun `0 이상의 정수형 숫자를 통해 티켓을 생성할 수 있다`(repeatInfo: RepetitionInfo) {
        val ticket = TicketCount(repeatInfo.currentRepetition)

        assertAll(
            { assertThat(ticket).isNotNull },
            { assertThat(ticket).isExactlyInstanceOf(TicketCount::class.java) },
        )
    }

    @ParameterizedTest(name = "입력값: {0}")
    @ValueSource(ints = [-1, -10, -100, Integer.MIN_VALUE])
    fun `티켓의 범위를 벗어난 값이 들어가면 티켓은 예외를 발생한다`(ticketCount: Int) {
        val exception = assertThrows<InvalidTicketCountRangeException> { TicketCount(ticketCount) }

        assertThat(exception.message).isEqualTo("%s는 Ticket 의 범위를 벗어난 값입니다.".format(ticketCount))
    }

    @ParameterizedTest(name = "입력값: {0}")
    @CsvSource(
        value = [
            "1:1:0", "1:0:1", "10:1:9", "10:10:0",
            "${Integer.MAX_VALUE}:1:${Integer.MAX_VALUE - 1}", "${Integer.MAX_VALUE}:${Integer.MAX_VALUE}:0"
        ],
        delimiter = ':'
    )
    fun `티켓끼리 빼기 연산을 할 수 있다`(standardCount: Int, operandCount: Int, expectedCount: Int) {
        val standardTicket = TicketCount(standardCount)
        val operandTicket = TicketCount(operandCount)
        val expected = TicketCount(expectedCount)
        val actual: TicketCount = standardTicket - operandTicket

        assertThat(actual).isEqualTo(expected)
    }
}
