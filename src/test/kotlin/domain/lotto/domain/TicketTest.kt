package domain.lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.RepeatedTest
import org.junit.jupiter.api.RepetitionInfo
import org.junit.jupiter.api.assertAll

@DisplayName("로또티켓(Ticket)")
class TicketTest {

    @RepeatedTest(value = 100, name = "현재, {currentRepetition}/{totalRepetitions}")
    fun `숫자를 통해 티켓을 생성할 수 있다`(repeatInfo: RepetitionInfo) {
        val ticket = Ticket(repeatInfo.currentRepetition)

        assertAll(
            { assertThat(ticket).isNotNull },
            { assertThat(ticket).isExactlyInstanceOf(Ticket::class.java) },
        )
    }
}
