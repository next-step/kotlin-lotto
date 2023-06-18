package lotto.domain.shop

import common.PositiveNumber
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe
import lotto.domain.lottonumber.LottoNumber
import lotto.domain.shop.machine.MockLottoGameMachine

class RealLottoShopTest : BehaviorSpec({

    Given("로또를 구매하면") {
        Then("구입 금액 만큼의 로또 게임 목록을 반환한다") {
            val mockLottoGameMachine = MockLottoGameMachine {
                LottoGame(
                    numbers = LottoNumber.allLottoNumbers()
                        .take(6)
                        .sorted(),
                )
            }
            val lottoShop = RealLottoShop(mockLottoGameMachine)
            val lottoGames = lottoShop.purchase(PositiveNumber(5_000)).lottoGames
            lottoGames.size shouldBe 5
        }
    }
})
