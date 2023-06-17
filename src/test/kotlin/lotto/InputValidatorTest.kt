package lotto

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.AnnotationSpec
import io.kotest.matchers.shouldBe
import lotto.domain.LottoNumber

class InputValidatorTest : AnnotationSpec() {

    @Test
    fun `구매금액은 숫자로 구성되어야 한다`() {
        InputParser.getBuyAmount("14000") shouldBe 14000

        shouldThrow<IllegalArgumentException> {
            InputParser.getBuyAmount("abc")
        }
    }

    @Test
    fun `당첨번호는 숫자로 구성되며 양수여야한다`() {
        val winNumberString = "1, 2, 3, 4, 5, 6"
        InputParser.parseWinNumbers(winNumberString) shouldBe listOf(1, 2, 3, 4, 5, 6).map { LottoNumber(it) }
    }
}
