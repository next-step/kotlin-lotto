package lotto.application.vo

import io.kotest.assertions.throwables.shouldNotThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class PurchaseTest : StringSpec({
    "구입 객체를 생성할 수 있다" {
        shouldNotThrow<Throwable> { Purchase(Amount(1_000)) }
    }

    "로또 구매 갯수를 조회할 수 있다" {
        Purchase(Amount(1_000)).lottoPurchaseCount shouldBe 1
    }
})
