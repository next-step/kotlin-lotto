package lotto

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import lotto.domain.Number

class NumberTest : StringSpec({
    "숫자는 1~46의 숫자가 아니면 예외를 던진다." {
        shouldThrow<IllegalArgumentException> { Number(0) }
        shouldThrow<IllegalArgumentException> { Number(47) }
    }
})
