package com.nextstep.lotto.domain

import com.nextstep.lotto.domain.LottoTicket.Companion.LOTTO_TICKET_COUNT
import io.kotest.assertions.throwables.shouldNotThrow
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.FreeSpec
import io.kotest.inspectors.forAll
import io.kotest.matchers.shouldBe
import java.lang.IllegalArgumentException

class LottoTicketTest : FreeSpec({
    "LottoTicket은 $LOTTO_TICKET_COUNT 개의 로또 번호로 구성된다." - {
        shouldNotThrow<RuntimeException> {
            LottoTicket(LottoTicketTestUtils.createLottoNumbers(1, 2, 3, 4, 5, 6))
        }
    }

    "LottoTicket은 $LOTTO_TICKET_COUNT 개 미만의 로또 번호로 생성할 수 없다." - {
        listOf(
            setOf(LottoNumber.from(1)),
            setOf(
                LottoNumber.from(1),
                LottoNumber.from(2)
            ),
            setOf(
                LottoNumber.from(1),
                LottoNumber.from(2),
                LottoNumber.from(3)
            ),
            setOf(
                LottoNumber.from(1),
                LottoNumber.from(2),
                LottoNumber.from(3),
                LottoNumber.from(4)
            ),
            setOf(
                LottoNumber.from(1),
                LottoNumber.from(2),
                LottoNumber.from(3),
                LottoNumber.from(4),
                LottoNumber.from(5)
            ),
            setOf(
                LottoNumber.from(1),
                LottoNumber.from(2),
                LottoNumber.from(3),
                LottoNumber.from(4),
                LottoNumber.from(5),
                LottoNumber.from(6),
                LottoNumber.from(7)
            )
        ).forAll { input ->
            "input: $input" {
                val exception = shouldThrow<IllegalArgumentException> { LottoTicket(input) }
                exception.message shouldBe "로또 티켓은 $LOTTO_TICKET_COUNT 개의 로또번호가 필요합니다."
            }
        }
    }
})
