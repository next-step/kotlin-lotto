package lotto.domain.shop

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe
import lotto.domain.lottonumber.LottoNumber
import lotto.domain.lottonumber.LottoNumbers
import lotto.domain.shop.lottonumberprovider.RealLottoNumberProvider
import math.PositiveNumber
import shffule.RandomShuffler

class RealLottoShopTest : BehaviorSpec({

    val lottoShop = RealLottoShop(
        LottoGameMachine(
            RealLottoNumberProvider(),
            RandomShuffler(),
        ),
    )

    fun lottoNumbers(vararg numbers: Int): LottoNumbers {
        return LottoNumbers(numbers.map { LottoNumber(it) })
    }

    fun mockSelfSettingLottoNumbersPapers(size: Int): List<SelfSettingLottoNumberPaper> {
        return List(size) {
            SelfSettingLottoNumberPaper(lottoNumbers(1, 2, 3, 4, 5, 6))
        }
    }

    Given("3개 중 3개의 로또 게임을 수동 구매 했다면") {
        val lottoPurchasePaper = LottoPurchasePaper(
            lottoPurchaseAmount = PositiveNumber(3_000),
            selfSettingLottoNumbersPapers = mockSelfSettingLottoNumbersPapers(3)
        )
        val lottoPurchaseResult = lottoShop.purchase(lottoPurchasePaper)

        Then("수동 3개, 자동 0개가 담긴 로또 게임 목록을 반환한다") {
            lottoPurchaseResult.selfSettingCount shouldBe 3
            lottoPurchaseResult.autoSettingCount shouldBe 0
        }
    }

    Given("3개 중 2개의 로또 게임을 수동 구매 했다면") {
        val lottoPurchasePaper = LottoPurchasePaper(
            lottoPurchaseAmount = PositiveNumber(3_000),
            selfSettingLottoNumbersPapers = mockSelfSettingLottoNumbersPapers(2)
        )
        val lottoPurchaseResult = lottoShop.purchase(lottoPurchasePaper)

        Then("수동 2개, 자동 1개가 담긴 로또 게임 목록을 반환한다") {
            lottoPurchaseResult.selfSettingCount shouldBe 2
            lottoPurchaseResult.autoSettingCount shouldBe 1
        }

        Then("로또 게임의 순서는 수동, 수동, 자동이다") {
            lottoPurchaseResult.lottoGames[0].type shouldBe LottoGameType.SELF
            lottoPurchaseResult.lottoGames[1].type shouldBe LottoGameType.SELF
            lottoPurchaseResult.lottoGames[2].type shouldBe LottoGameType.AUTO
        }
    }

    Given("3개 중 1개의 로또 게임을 수동 구매 했다면") {
        val lottoPurchasePaper = LottoPurchasePaper(
            lottoPurchaseAmount = PositiveNumber(3_000),
            selfSettingLottoNumbersPapers = mockSelfSettingLottoNumbersPapers(1)
        )
        val lottoPurchaseResult = lottoShop.purchase(lottoPurchasePaper)

        Then("수동 1개, 자동 2개가 담긴 로또 게임 목록을 반환한다") {
            lottoPurchaseResult.selfSettingCount shouldBe 1
            lottoPurchaseResult.autoSettingCount shouldBe 2
        }

        Then("로또 게임의 순서는 수동, 자동, 자동이다") {
            lottoPurchaseResult.lottoGames[0].type shouldBe LottoGameType.SELF
            lottoPurchaseResult.lottoGames[1].type shouldBe LottoGameType.AUTO
            lottoPurchaseResult.lottoGames[2].type shouldBe LottoGameType.AUTO
        }
    }

    Given("3개 중 1개도 수동 구매를 하지 않았다면") {
        val lottoPurchasePaper = LottoPurchasePaper(
            lottoPurchaseAmount = PositiveNumber(3_000),
            selfSettingLottoNumbersPapers = emptyList()
        )
        val lottoPurchaseResult = lottoShop.purchase(lottoPurchasePaper)

        Then("자동 3개가 담긴 로또 게임 목록을 반환한다") {
            lottoPurchaseResult.selfSettingCount shouldBe 0
        }
    }
})
