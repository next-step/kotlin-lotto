package lotto

import io.kotest.assertions.throwables.shouldNotThrowAny
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class AmountTest : StringSpec({
    "로또 구입 금액은 1000원 단위로 입력한다." {
        shouldNotThrowAny { Amount(1000) }
    }
    "금액을 숫자로 나눠서 반환할 수 있다." {
        Amount(1000).divide(100) shouldBe 10
    }
})
