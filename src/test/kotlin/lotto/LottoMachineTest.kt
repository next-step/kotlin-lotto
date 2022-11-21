package lotto

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe
import io.mockk.every
import io.mockk.mockkObject
import io.mockk.unmockkObject
import lotto.util.RandomNumberGenerator
import lotto.util.Reader

internal class LottoMachineTest : BehaviorSpec({
    Given("로또 머신을 생성하고, ") {
        mockkObject(RandomNumberGenerator, Reader)
        val money = 1000
        every { RandomNumberGenerator.generate(any()) }.returnsMany(1, 2, 3, 4, 5, 6)
        every { Reader.read() }.returns("1, 2, 3, 4, 5, 6")
        val lottoMachine = LottoMachine(money)

        When("수행한다면, ") {
            lottoMachine.execute()
            val summary = lottoMachine.getSummary()
            Then("결과 값을 받아올 수 있다.") {
                summary.winners[0].count shouldBe 0
                summary.winners[1].count shouldBe 0
                summary.winners[2].count shouldBe 0
                summary.winners[3].count shouldBe 1
            }
        }
        unmockkObject(RandomNumberGenerator, Reader)
    }
})
