package lotto.domain

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class ProductCountSpec : FunSpec({
    test("주어진 횟수만큼 전달된 로직이 실행된다") {
        var count = 0
        val increase = { count++ }

        val productCount = ProductCount(5)
        productCount.runForCount(increase)

        count shouldBe productCount.value
    }
})
