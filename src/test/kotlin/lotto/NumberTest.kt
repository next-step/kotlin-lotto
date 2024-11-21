package lotto

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class NumberTest : StringSpec({

    "숫자는 양수의 값을 갖고 있다." {
        Number(1).value shouldBe 1
    }

    "숫자는 0이나 음수일 수 없다." {
        shouldThrow<IllegalArgumentException> { Number(0) }
        shouldThrow<IllegalArgumentException> { Number(-1) }
    }
})
