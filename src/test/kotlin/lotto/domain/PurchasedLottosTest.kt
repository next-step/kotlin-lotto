package lotto.domain

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe

class PurchasedLottosTest : BehaviorSpec({
    Given("구입한 로또 목록이 주어졌을 때") {
        When("로또 목록이 비어 있지 않은 경우") {
            val lottos =
                listOf(
                    Lotto(setOf(1, 2, 3, 4, 5, 6)),
                    Lotto(setOf(7, 8, 9, 10, 11, 12)),
                )
            val purchasedLottos = PurchasedLottos(lottos)

            Then("생성된 PurchasedLottos의 로또 개수는 2개이다") {
                purchasedLottos.lottos.size shouldBe 2
            }

            Then("구입한 로또 번호는 입력한 번호와 동일하다") {
                purchasedLottos.lottos shouldBe lottos
            }
        }

        When("로또 목록이 비어 있는 경우") {
            val purchasedLottos = PurchasedLottos(emptyList())

            Then("생성된 PurchasedLottos의 로또 개수는 0개이다") {
                purchasedLottos.lottos.size shouldBe 0
            }
        }
    }
    Given("구입한 로또 목록과 당첨 번호가 주어졌을 때") {
        val winningLotto = WinningLotto(Lotto(setOf(1, 2, 3, 4, 5, 6)), BonusNumber(7))

        When("각 로또의 매칭 개수에 따라 Rank를 계산하면") {
            val lottos =
                listOf(
                    Lotto(setOf(1, 2, 3, 4, 5, 6)),
                    Lotto(setOf(1, 2, 3, 4, 7, 8)),
                    Lotto(setOf(1, 2, 3, 7, 8, 9)),
                    Lotto(setOf(7, 8, 9, 10, 11, 12)),
                )
            val purchasedLottos = PurchasedLottos(lottos)
            val ranks = purchasedLottos.calculateRanks(winningLotto)

            Then("Rank별 매칭 결과가 올바르게 계산된다") {
                ranks[Rank.FIRST] shouldBe MatchedCount(1)
                ranks[Rank.FOURTH] shouldBe MatchedCount(1)
                ranks[Rank.FIFTH] shouldBe MatchedCount(1)
                ranks[Rank.MISS] shouldBe MatchedCount(1)
            }
        }

        When("로또 목록이 비어 있을 때 Rank를 계산하면") {
            val purchasedLottos = PurchasedLottos(emptyList())
            val ranks = purchasedLottos.calculateRanks(winningLotto)

            Then("Rank 결과는 빈 Map이어야 한다") {
                ranks shouldBe emptyMap()
            }
        }
    }
})
