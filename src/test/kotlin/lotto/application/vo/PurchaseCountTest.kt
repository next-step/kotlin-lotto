package lotto.application.vo

import io.kotest.assertions.throwables.shouldNotThrow
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec

class PurchaseCountTest : StringSpec({
    "구입 개수 객체를 생성할수 있다" {
        shouldNotThrow<Throwable> { PurchaseCount(1) }
    }

    "구입 개수가 음수일 경우 Exception을 던진다" {
        shouldThrow<IllegalArgumentException> { PurchaseCount(-1) }
    }
})
