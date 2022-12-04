package lotto

import io.kotest.assertions.throwables.shouldNotThrowAny
import io.kotest.core.spec.style.BehaviorSpec
import io.mockk.every
import io.mockk.mockkObject
import lotto.domain.strategy.bonus.BonusManualGenerateStrategy
import lotto.domain.strategy.lotto.LottoAutoGenerateStrategy
import lotto.domain.LottoMachine
import lotto.domain.strategy.lotto.LottoManualGenerateStrategy
import lotto.util.Reader

internal class LottoMachineTest : BehaviorSpec({
    Given("로또 머신을 생성하고, ") {
        mockkObject(Reader)
        val money = 1000
        every { Reader.read() }.returnsMany(listOf("1, 2, 3, 4, 5, 6", "7"))
        val lottoMachine = LottoMachine(
            money = money,
            lottoGenerateStrategy = LottoAutoGenerateStrategy(),
            winnerLottoGenerateStrategy = LottoManualGenerateStrategy(),
            bonusGenerateStrategy = BonusManualGenerateStrategy(),
        )

        When("수행한다면, ") {
            Then("결과 값을 받아올 수 있다.") {
                shouldNotThrowAny {
                    lottoMachine.execute()
                }
            }
        }
    }
})
