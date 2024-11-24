package lotto

import io.kotest.assertions.assertSoftly
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec

class LottoNumberValidatorTest : StringSpec({
    "전달된 Set의 길이가 6인지 검사할 수 있다. 6개가 아닐 경우 예외를 반환한다." {
        assertSoftly {
            shouldThrow<IllegalArgumentException> { LottoNumberValidator.validateNumbers(setOf(1, 2, 3, 4, 5)) }
            shouldThrow<IllegalArgumentException> { LottoNumberValidator.validateNumbers(setOf(1, 2, 3, 4, 5, 6, 7)) }
        }
    }

    "전달된 Set의 숫자들이 1 ~ 45 사이의 값을 가지고 있는지 검사할 수 있다. " {
        assertSoftly {
            shouldThrow<IllegalArgumentException> { LottoNumberValidator.validateNumbers(setOf(1, 2, 3, 4, 5, 46)) }
            shouldThrow<IllegalArgumentException> { LottoNumberValidator.validateNumbers(setOf(0, 2, 3, 4, 5, 6)) }
        }
    }
})
