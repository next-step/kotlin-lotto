package lotto.domain.shop

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe
import lotto.domain.lottonumber.lottoNumbers
import math.PositiveNumber

class LottoPurchasePaperTest : BehaviorSpec({

    Given("2000원 중 0개를 수동 선택 했을 때") {
        val lottoPurchasePaper = LottoPurchasePaper(
            lottoPurchaseAmount = PositiveNumber(2_000),
            selfSettingLottoNumbersPapers = emptyList()
        )
        Then("로또 가격이 1000원이면 자동 구매 개수는 0이다") {
            lottoPurchasePaper.autoPurchaseSize(PositiveNumber(1_000)) shouldBe 2
        }
    }

    Given("2000원 중 1개를 수동 선택 했을 때") {
        val lottoPurchasePaper = LottoPurchasePaper(
            lottoPurchaseAmount = PositiveNumber(2_000),
            selfSettingLottoNumbersPapers = listOf(
                SelfSettingLottoNumberPaper(lottoNumbers(1, 2, 3, 4, 5, 6))
            )
        )
        Then("로또 가격이 1000원이면 자동 구매 개수는 1이다") {
            lottoPurchasePaper.autoPurchaseSize(PositiveNumber(1_000)) shouldBe 1
        }
    }

    Given("2000원 중 2개를 수동 선택 했을 때") {
        val lottoPurchasePaper = LottoPurchasePaper(
            lottoPurchaseAmount = PositiveNumber(2_000),
            selfSettingLottoNumbersPapers = listOf(
                SelfSettingLottoNumberPaper(lottoNumbers(1, 2, 3, 4, 5, 6)),
                SelfSettingLottoNumberPaper(lottoNumbers(1, 2, 3, 4, 5, 6)),
            )
        )
        Then("로또 가격이 1000원이면 자동 구매 개수는 0이다") {
            lottoPurchasePaper.autoPurchaseSize(PositiveNumber(1_000)) shouldBe 0
        }
    }
})
