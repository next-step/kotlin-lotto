package lotto.controller

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe
import lotto.domain.numberGenerator.FixedLottoNumberGenerator

class LottoShopTest : BehaviorSpec({

    Given("LottoShop에서 로또를 구매할 때") {
        val lottoFactory = LottoFactory(FixedLottoNumberGenerator(listOf(13, 14, 15, 16, 17, 18)))
        val lottoShop = LottoShop(lottoFactory)
        val manualLottoNumbers = listOf(
           listOf(1, 2, 3, 4, 5, 6),
            listOf(7, 8, 9, 10, 11, 12)
        )
        val randomLottoCount = 5
        val lottoTicket = LottoTicket(manualLottoNumbers, randomLottoCount)
        When("입력 금액과 수동 로또 번호로 로또를 구매하면") {
            val lottos = lottoShop.purchaseLottos(lottoTicket)

            Then("예상되는 총 로또 개수가 수동 로또 개수 + 자동 로또 개수여야 한다.") {
                lottos.getSize() shouldBe 7
            }

            And("수동 로또 번호가 올바르게 포함되어야 한다.") {
                lottos.lottoList[0].lottoNumbers.map { it.value }.toList()shouldBe manualLottoNumbers[0]
            }

            And("자동 로또 번호가 올바르게 생성되어야 한다.") {
                lottos.lottoList.subList(2, 5).all { lotto ->
                    lotto.lottoNumbers.map { it.value } == listOf(13, 14, 15, 16, 17, 18)
                } shouldBe true
            }
        }
    }
})
