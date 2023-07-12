package lotto.domain

import io.kotest.assertions.throwables.shouldThrow
import org.junit.jupiter.api.Test

class LottoTicketTest {
    @Test
    fun `빈 로또를 전달하면 예외가 발생한다`() {
        shouldThrow<IllegalArgumentException> { LottoTicket(listOf()) }
    }
}
