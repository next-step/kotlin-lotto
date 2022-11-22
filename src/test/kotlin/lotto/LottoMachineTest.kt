package lotto

import io.kotest.assertions.throwables.shouldNotThrowAny
import io.kotest.core.spec.style.BehaviorSpec
import io.mockk.every
import io.mockk.mockkObject
import lotto.domain.LottoMachine
import lotto.util.Reader

internal class LottoMachineTest : BehaviorSpec({
    Given("로또 머신을 생성하고, ") {
        mockkObject(Reader)
        val money = 1000
        every { Reader.read() }.returns("1, 2, 3, 4, 5, 6")
        val lottoMachine = LottoMachine(money)

        When("수행한다면, ") {
            Then("결과 값을 받아올 수 있다.") {
                shouldNotThrowAny {
                    lottoMachine.getSummary()
                }
            }
        }
    }
})
