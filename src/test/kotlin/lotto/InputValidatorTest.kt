package lotto

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.AnnotationSpec
import io.kotest.matchers.shouldBe

class InputValidatorTest : AnnotationSpec() {

    @Test
    fun `구매금액은 숫자로 구성되어야 한다`() {

        InputValidator.parseWinNumbers("14000") shouldBe 14000

        shouldThrow<IllegalArgumentException> {
            InputValidator.parseWinNumbers("abc")
        }
    }

    @Test
    fun `로또 구매를 할 수 있는지를 체크한다`() {

        InputValidator.canBuyLotto(1000) shouldBe true
        InputValidator.canBuyLotto(-15000) shouldBe false
    }

    @Test
    fun `당첨번호는 숫자로 구성되며 양수여야한다`() {

        val winNumberString = "1, 2, 3, 4, 5, 6"
        InputValidator.parseWinNumbers(winNumberString) shouldBe listOf(1, 2, 3, 4, 5, 6)
    }
}
