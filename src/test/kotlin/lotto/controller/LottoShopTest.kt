package lotto.controller

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe
import lotto.domain.LottoNumber
import lotto.domain.LottoNumbers
import lotto.domain.numberGenerator.FixedLottoLottoNumberGenerator

class LottoShopTest : BehaviorSpec({

    Given("LottoShop에서 로또를 구매할 때") {
        val lottoFactory = LottoFactory(FixedLottoLottoNumberGenerator(listOf(13, 14, 15, 16, 17, 18)))
        val lottoShop = LottoShop(lottoFactory)
        val manualLottoNumbers = listOf(
            LottoNumbers(listOf(1, 2, 3, 4, 5, 6).map { LottoNumber(it) }),
            LottoNumbers(listOf(7, 8, 9, 10, 11, 12).map { LottoNumber(it) })
        )
        val inputMoney = 5000

        When("입력 금액과 수동 로또 번호로 로또를 구매하면") {
            val lottos = lottoShop.purchaseLottos(manualLottoNumbers, inputMoney)

            Then("예상되는 총 로또 개수가 수동 로또 개수 + 자동 로또 개수여야 한다.") {
                lottos.getSize() shouldBe 5
            }

            And("수동 로또 번호가 올바르게 포함되어야 한다.") {
                lottos.lottoList.subList(0, 2) shouldBe manualLottoNumbers
            }

            And("자동 로또 번호가 올바르게 생성되어야 한다.") {
                lottos.lottoList.subList(2, 5).all { lotto ->
                    lotto.lottoNumbers.map { it.value } == listOf(13, 14, 15, 16, 17, 18)
                } shouldBe true
            }
        }
    }
})
