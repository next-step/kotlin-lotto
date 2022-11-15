package lotto

import io.kotest.core.spec.style.StringSpec
import lotto.domain.LottoTicket
import org.junit.jupiter.api.assertAll
import org.junit.jupiter.api.assertThrows

class LottoTicketTest : StringSpec({
    "LottoTicket의 LottoNumber의 개수가 6개가 아니면 IllegalArgumentException이 발생한다." {
        assertAll(
            { assertThrows<IllegalArgumentException> { LottoTicket(setOf()) } },
            { assertThrows<IllegalArgumentException> { LottoTicket.of(setOf(1, 2, 3, 4, 5, 6, 7)) } }
        )
    }
})
