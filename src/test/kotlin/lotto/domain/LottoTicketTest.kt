package lotto.domain

import io.kotest.assertions.throwables.shouldThrowExactly
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class LottoTicketTest : StringSpec({

    "로또 티켓은 6개의 숫자를 가지고 있다" {
        val lottoTicket = LottoTicket.of(1, 2, 3, 4, 5, 6)
        lottoTicket.size shouldBe 6
    }

    "로또 티켓은 1~45 범위의 숫자를 입력하지 않은 경우 IllegalArgumentException을 발생한다" {
        shouldThrowExactly<IllegalArgumentException> {
            LottoTicket.of(0, 2, 3, 4, 5, 6)
        }
    }

    "로또 티켓은 6개 이하의 숫자를 입력하게 되면 IllegalArgumentException을 발생한다" {
        shouldThrowExactly<IllegalArgumentException> {
            LottoTicket.of(1)
        }
    }

    "로또 티켓은 6개 이상의 숫자를 입력하게 되면 IllegalArgumentException을 발생한다" {
        shouldThrowExactly<IllegalArgumentException> {
            LottoTicket(setOf(1, 2, 3, 4, 5, 6, 7))
        }
    }
})
