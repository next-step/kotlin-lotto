package lotto.domain

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.AnnotationSpec
import io.kotest.matchers.shouldBe
import lotto.InputValidator

class LottoMachineTest : AnnotationSpec() {

    @Test
    fun `구매금액은 숫자로 구성되어야 한다`() {

        InputValidator.parseAmount("14000") shouldBe 14000

        shouldThrow<IllegalArgumentException> {
            InputValidator.parseAmount("abc")
        }
    }

    @Test
    fun `로또 구매를 할 수 있는지를 체크한다`() {

        InputValidator.canBuyLotto(1000) shouldBe true
        InputValidator.canBuyLotto(-15000) shouldBe false
    }
}
