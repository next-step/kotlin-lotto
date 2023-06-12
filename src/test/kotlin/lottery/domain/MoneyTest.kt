package lottery.domain

import io.kotest.assertions.throwables.shouldThrowExactly
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class MoneyTest : FunSpec({

    context("init") {
        test("돈은 음수가 입력될 경우 예외가 발생한다") {
            val exception = shouldThrowExactly<IllegalArgumentException> { Money(value = -1) }
            exception.message shouldBe "돈은 음수가 입력될 수 없다"
        }
    }
})
