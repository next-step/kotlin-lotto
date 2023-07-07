package lotto

import io.kotest.assertions.throwables.shouldNotThrowAny
import io.kotest.assertions.throwables.shouldThrow
import org.junit.jupiter.api.Test

class LottoTicketTest {
    @Test
    fun `빈 로또를 전달하면 예외가 발생한다`() {
        shouldThrow<IllegalArgumentException> { LottoTicket(listOf()) }
    }

    @Test
    fun `숫자 목록 여러개를 받아 로또 티켓을 생성한다`() {
        val lottos = listOf(
            listOf(1, 2, 3, 4, 5, 6),
            listOf(1, 2, 3, 4, 5, 6),
            listOf(1, 2, 3, 4, 5, 6),
        )

        shouldNotThrowAny { LottoTicket.from(lottos) }
    }
}
