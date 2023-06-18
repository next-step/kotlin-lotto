package lotto.domain.shop

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe

class RealLottoShopTest : BehaviorSpec({

    Given("로또를 구매하면") {

        Then("구입 금액 만큼의 로또 게임 목록을 반환한다") {
            val lottoGames = RealLottoShop().purchase(lottoPurchaseAmount = 5_000)
                .lottoGames
            lottoGames.size shouldBe 5
        }

        Then("한장의 로또 게임에 담긴 로또 번호 개수는 6개이다") {
            val lottoNumbers = RealLottoShop().purchase(lottoPurchaseAmount = 1_000)
                .lottoGames
                .first()
                .numbers
            lottoNumbers.size shouldBe 6
        }

        Then("로또 게임에 담긴 로또 번호 목록에는 중복이 없다") {
            val lottoNumbers = RealLottoShop().purchase(lottoPurchaseAmount = 1_000)
                .lottoGames
                .first()
                .numbers
            lottoNumbers.distinct() shouldBe lottoNumbers
        }

        Then("로또 게임에 담긴 로또 번호 목록은 오름차순 정렬이 되어있다") {
            val lottoNumbers = RealLottoShop().purchase(lottoPurchaseAmount = 1_000)
                .lottoGames
                .first()
                .numbers
            lottoNumbers shouldBe lottoNumbers.sorted()
        }

        Then("각 로또 번호의 범위는 0 이상 45 이하이다") {
            val lottoNumbers = RealLottoShop().purchase(lottoPurchaseAmount = 1_000)
                .lottoGames
                .first()
                .numbers
            lottoNumbers.all { it in (1..45) } shouldBe true
        }
    }
})
