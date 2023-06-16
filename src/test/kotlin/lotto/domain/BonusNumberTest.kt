package lotto.domain

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.AnnotationSpec
import io.kotest.matchers.types.shouldBeTypeOf

class BonusNumberTest : AnnotationSpec() {

    @Test
    fun `보너스 숫자는 당첨 숫자와 중복이 될 수 없음 또한 1보다 작거나 45보다 클 수 없음`() {
        val winNumber = LottoNumber(listOf(1, 2, 3, 4, 5, 6))
        BonusNumber(winNumber, 7).shouldBeTypeOf<BonusNumber>()
        shouldThrow<IllegalArgumentException> {
            BonusNumber(winNumber, 6)
        }
        shouldThrow<IllegalArgumentException> {
            BonusNumber(winNumber, 0)
        }
    }
}
