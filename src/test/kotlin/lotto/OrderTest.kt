package lotto

import io.kotest.assertions.assertSoftly
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class OrderTest : StringSpec({
    "주문이 생성되면 전달된 금액에 맞는 로또를 소지한다." {
        val order = Order(5000, FixedNumberGenerator())

        order.lottos.size shouldBe 5
    }

    "주문 생성 시 전달된 금액이 1000원 단위가 아닐 경우 예외를 반환한다." {
        shouldThrow<IllegalArgumentException> { Order(10001) }
    }

    "주문 생성 시 전달된 금액이 음수 혹은 0원일 경우 예외를 반환한다." {
        assertSoftly {
            shouldThrow<IllegalArgumentException> { Order(-1) }
            shouldThrow<IllegalArgumentException> { Order(0) }
        }
    }
})
