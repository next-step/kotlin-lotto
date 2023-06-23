package domain

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class OrderTest : StringSpec({
    "Order를 만들 때 수동 구매 수량을 확인한다." {
        Order(14_000, 14, listOf())
        val maxSize = 14_000 / 1000
        val requestSize = 15
        shouldThrow<IllegalArgumentException> {
            Order(14_000, requestSize, listOf()) shouldBe false
        }.message shouldBe "${requestSize}수동 구매 수량은 ${maxSize}보다 작아야 합니다."
    }
})
