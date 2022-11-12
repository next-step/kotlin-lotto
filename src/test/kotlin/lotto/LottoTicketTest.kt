package lotto

import io.kotest.core.spec.style.StringSpec
import org.junit.jupiter.api.assertAll
import org.junit.jupiter.api.assertThrows

class LottoTicketTest : StringSpec({
    "LottoTicket의 LottoNumber의 개수가 6개가 아니면 IllegalArgumentException이 발생한다." {
        assertAll(
            {assertThrows<IllegalArgumentException> { LottoTicket(listOf()) }},
            {assertThrows<IllegalArgumentException> { LottoTicket(listOf(
                LottoNumber(1),
                LottoNumber(2),
                LottoNumber(3),
                LottoNumber(4),
                LottoNumber(5),
                LottoNumber(6),
                LottoNumber(7),
            )) }}
        )
    }

})