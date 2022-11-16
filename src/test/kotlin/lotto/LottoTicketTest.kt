package lotto

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.throwable.shouldHaveMessage
import lotto.domain.LottoTicket
import org.junit.jupiter.api.assertAll
import org.junit.jupiter.api.assertThrows

class LottoTicketTest : StringSpec({
    "LottoTicket의 LottoNumber의 개수가 6개가 아니면 IllegalArgumentException이 발생한다." {
        assertAll(
            { assertThrows<IllegalArgumentException> { LottoTicket(setOf()) } .shouldHaveMessage("로또 티켓의 번호는 6개의 숫자로 이루어져야 합니다.") },
            { assertThrows<IllegalArgumentException> { LottoTicket.of(setOf(1, 2, 3, 4, 5, 6, 7)) }.shouldHaveMessage("로또 티켓의 번호는 6개의 숫자로 이루어져야 합니다.") }
        )
    }
})
