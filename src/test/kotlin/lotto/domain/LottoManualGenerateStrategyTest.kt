package lotto.domain

import io.kotest.assertions.throwables.shouldNotThrowAny
import io.kotest.core.spec.style.BehaviorSpec
import io.mockk.every
import io.mockk.mockkObject
import lotto.domain.input.ConsoleInput
import lotto.domain.strategy.lotto.LottoManualGenerateStrategy
import lotto.util.Reader

internal class LottoManualGenerateStrategyTest : BehaviorSpec({
    mockkObject(Reader)
    Given("수동 입력으로 진행한 당첨 티켓이 ") {
        When("정상적이라면 ") {
            every { Reader.read() } returns "1, 2, 3, 4, 5, 6"
            Then("정상적으로 생성한다.") {
                shouldNotThrowAny {
                    LottoManualGenerateStrategy(ConsoleInput()).generate()
                }
            }
        }
    }
})
