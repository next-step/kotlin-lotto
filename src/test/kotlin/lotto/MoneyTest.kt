package lotto

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

internal class MoneyTest : FunSpec({

    test("구매 금액 입력값은 0이상의 정수여야 한다.") {
        shouldThrow<IllegalArgumentException> {
            Money(-1)
        }
    }

    test("금액을 1000원으로 나눠서 구매 가능한 로또 티켓의 수를 구할 수 있다.") {
        // given
        val sut = Money(2000)

        // when
        val result = sut.lottoTicketCount()

        // then
        result shouldBe 2
    }
})
