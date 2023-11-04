package lotto.domain

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class AmountSpec : FunSpec({
    test("금액이 생성된다") {
        val amount = 1000

        val result = Amount(amount)

        result.value shouldBe amount
    }

    test("0보다 크지 않은 수로 금액 생성시 생성에 실패한다") {
        val amount = -100

        shouldThrow<IllegalArgumentException> {
            Amount(amount)
        }
    }
})
