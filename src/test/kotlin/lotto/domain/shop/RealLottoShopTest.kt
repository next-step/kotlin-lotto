package lotto.domain.shop

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe
import lotto.domain.shop.lottonumberprovider.RealLottoNumberProvider
import math.PositiveNumber
import shffule.RandomShuffler

class RealLottoShopTest : BehaviorSpec({

    Given("로또를 구매하면") {
        val lottoPurchaseAmount = PositiveNumber(5_000)
        val lottoPurchaseResult = RealLottoShop(
            LottoGameMachine(
                RealLottoNumberProvider(),
                RandomShuffler(),
            ),
        ).purchase(lottoPurchaseAmount)
        Then("구입 금액 만큼의 로또 게임 목록을 반환한다") {
            lottoPurchaseResult.lottoGames.size shouldBe 5
        }
    }
})
