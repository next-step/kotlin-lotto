package lotto.domain

import io.kotest.assertions.throwables.shouldNotThrowAny
import io.kotest.assertions.throwables.shouldThrowExactly
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class PurchasedMoneyTest : StringSpec({
    "구입 금액 객체를 생성한다" {
        // given
        val money = 1_000

        // when // then
        shouldNotThrowAny { Money(money) }
    }

    "음수의 값을 가진 구입 금액 객체를 생성하면 예외를 발생시킨다" {
        // given
        val money = -1_000

        // when // then
        shouldThrowExactly<IllegalArgumentException> { Money(money) }
    }

    "구입 금액에 맞는 로또 갯수를 반환한다" {
        // given
        val money = Money(1_000)

        // when
        val result = money.calculateLottoNumber()

        // then
        result shouldBe 1
    }
})
