package lotto

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.assertDoesNotThrow

class AmountTest : StringSpec({
    "로또 구입 금액은 1000원 단위로 입력한다." {
        assertDoesNotThrow { Amount(1000) }
    }
    "로또 구입 금액은 1000원 단위가 아니면 예외가 발생한다." {
        shouldThrow<IllegalArgumentException> {
            Amount(1001)
        }
    }
    "금액을 숫자로 나눠서 반환할 수 있다." {
        Amount(1000).divide(100) shouldBe 10
    }
})
