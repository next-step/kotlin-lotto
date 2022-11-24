package lotto.domain

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe
import io.mockk.every
import io.mockk.mockkObject
import lotto.util.ExceptionMessage
import lotto.util.Reader
import java.lang.IllegalArgumentException

internal class BonusManualGenerateStrategyTest : BehaviorSpec({
    mockkObject(Reader)
    Given("보너스 넘버는 ") {
        When("숫자로 들어오지 않으면 ") {
            every { Reader.read() } returns "test"
            Then("에러를 발생해요.") {
                val exception = shouldThrow<IllegalArgumentException> {
                    BonusManualGenerateStrategy().generate()
                }
                exception.message shouldBe ExceptionMessage.BONUS_NUMBER_ERROR
            }
        }

        When("숫자로 들어오면") {
            every { Reader.read() } returns "10"
            val lottoNumber = BonusManualGenerateStrategy().generate()
            Then("정상적으로 로또 넘버를 생성해요.") {
                lottoNumber.number shouldBe 10
            }
        }
    }
})
