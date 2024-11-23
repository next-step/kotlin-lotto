package lotto.domain

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec

class NumberTest : StringSpec({
    "숫자는 1~46의 숫자가 아니면 예외를 던진다." {
        shouldThrow<IllegalArgumentException> { Number(0) }
        shouldThrow<IllegalArgumentException> { Number(47) }
    }
})
