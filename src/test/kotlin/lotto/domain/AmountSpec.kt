package lotto.domain

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class AmountSpec : FunSpec({
    context("금액 생성") {
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
    }

    test("금액을 실수로 반환한다") {
        val amount = Amount(3000)

        val result = amount.toDouble()

        result shouldBe 3000
    }

    context("총합 계산") {
        test("Amount 리스트의 총 합이 계산된다") {
            val amounts = listOf(Amount(1000), Amount(2000), Amount(30000))

            val result = amounts.sum()

            result shouldBe Amount(33000)
        }
    }
})
