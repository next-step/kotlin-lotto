package calculator

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class NumberTest : StringSpec({
    "숫자는 양수 값 하나를 가진다." {
        Number(1).value shouldBe 1
    }

    "숫자는 음수를 가진 값으로 생성될 시 예외가 발생한다." {
        shouldThrow<IllegalArgumentException> { Number(-1) }
    }
})
