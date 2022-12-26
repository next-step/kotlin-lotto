package lotto.domain

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import java.lang.IllegalArgumentException

class LottoTicketTest : StringSpec({
    "로또는 6개의 로또 숫자를 가지고 있어요" {
        val lotto = LottoTicket(
            setOf(
                LottoNumber(1),
                LottoNumber(2),
                LottoNumber(3),
                LottoNumber(4),
                LottoNumber(5),
                LottoNumber(6),
            )
        )

        lotto.numbers.size shouldBe 6
    }

    "로또의 숫자가 6개가 아니라면 IllegalArgumentException이 발생해요" {
        shouldThrow<IllegalArgumentException> {
            LottoTicket(
                setOf(
                    LottoNumber(1),
                    LottoNumber(2),
                    LottoNumber(3),
                    LottoNumber(4),
                    LottoNumber(5),
                )
            )
        }
    }
})
