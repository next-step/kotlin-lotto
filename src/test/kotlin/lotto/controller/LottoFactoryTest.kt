package lotto.controller

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe
import lotto.domain.LottoNumbers
import lotto.domain.numberGenerator.FixedLottoNumberGenerator

class LottoFactoryTest : BehaviorSpec({

    Given("수동으로 로또를 발급 받을때") {
        val manualLottoCount = 2
        val manualLottoNumbers = listOf(
            listOf(1, 2, 3, 4, 5, 6),
            listOf(7, 8, 9, 10, 11, 12)
        )

        When("입력 받은 번호로 수동 로또 번호를 생성할 때") {
            val manualLottos = manualLottoNumbers.map { inputNumbers ->
                val numberGenerator = FixedLottoNumberGenerator(inputNumbers)
                LottoNumbers(numberGenerator.generateNumbers())
            }

            Then("예상되는 수동 로또 번호들이 반환되어야 한다") {
                manualLottos.size shouldBe manualLottoCount
                manualLottos[0].lottoNumbers.map { it.value } shouldBe manualLottoNumbers[0]
                manualLottos[1].lottoNumbers.map { it.value } shouldBe manualLottoNumbers[1]
            }
        }
    }
})
