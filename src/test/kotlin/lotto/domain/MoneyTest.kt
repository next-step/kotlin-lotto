package lotto.domain

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.FreeSpec
import io.kotest.matchers.shouldBe

class MoneyTest : FreeSpec({

    "Money 객체의 유효성 검증 테스트" - {
        "input이 양수인 경우" {
            // given
            val input = 1000
            // when
            val money = Money(input)
            // then
            money.price shouldBe 1000
        }

        "input이 0원인 경우" {
            // given
            val input = 0
            // when
            val money = Money(input)
            // then
            money.price shouldBe 0
        }

        "input이 음수인 경우" {
            // given
            val input = -1000
            // when
            val exception =
                shouldThrow<IllegalArgumentException> { Money(input) }
            // then
            exception.message shouldBe "금액은 0 혹은 양수여야합니다."
        }
    }
})
