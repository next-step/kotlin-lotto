package lotto

import io.kotest.assertions.throwables.shouldNotThrowAny
import io.kotest.assertions.throwables.shouldThrowExactly
import io.kotest.core.spec.DisplayName
import io.kotest.core.spec.style.StringSpec

@DisplayName("로또 티켓")
class LottoTicketTest : StringSpec({

    "로또 번호는 6개" {
        shouldNotThrowAny {
            LottoTicket(LottoNumber(1)..LottoNumber(6))
        }
    }

    "로또 번호가 6개가 아니면 예외 발생" {
        shouldThrowExactly<IllegalArgumentException> {
            LottoTicket(LottoNumber(1)..LottoNumber(5))
        }
    }
})
