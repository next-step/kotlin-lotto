package lotto.step4

import io.kotest.assertions.throwables.shouldNotThrow
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.FunSpec
import lotto.step4.domain.InputValidator
import lotto.step4.domain.Money

class InputValidatorTest : FunSpec({
    test("최대 구입가능한 로또 개수를 초과하는 경우 예외가 발생한다.") {
        // given
        val money = Money(5000)
        val count = 6L

        // when, then
        shouldThrow<IllegalArgumentException> {
            InputValidator.validateManualPurchaseCount(money, count)
        }
    }

    test("최대 구입가능한 로또 개수를 초과하지 않는 경우 예외가 발생하지 않는다.") {
        // given
        val money = Money(5000)
        val count = 5L

        // when, then
        shouldNotThrow<IllegalArgumentException> {
            InputValidator.validateManualPurchaseCount(money, count)
        }
    }
})
