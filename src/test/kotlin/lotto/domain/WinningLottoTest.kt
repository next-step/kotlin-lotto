package lotto.domain

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.data.forAll
import io.kotest.data.row
import io.kotest.matchers.shouldBe
import io.kotest.matchers.shouldNotBe

class WinningLottoTest : BehaviorSpec({
    Given("당첨 번호가 주어졌을 때") {
        val validWinningLotto = Lotto.from(setOf(1, 2, 3, 4, 5, 6))

        When("당첨 로또 객체를 생성하면") {
            val winningLotto = WinningLotto(validWinningLotto, BonusNumber.create(7, validWinningLotto))

            Then("객체가 정상적으로 생성된다") {
                winningLotto shouldNotBe null
            }
        }
    }

    Given("당첨 복권과 당첨 로또 번호가 주어졌을 때") {
        val validWinningLotto = Lotto.from(setOf(1, 2, 3, 4, 5, 6))
        val winningLotto = WinningLotto(validWinningLotto, BonusNumber.create(7, validWinningLotto))

        forAll(
            row(setOf(1, 2, 3, 4, 5, 6), Rank.FIRST),
            row(setOf(1, 2, 3, 4, 5, 7), Rank.SECOND),
            row(setOf(1, 2, 3, 4, 5, 8), Rank.THIRD),
            row(setOf(1, 2, 3, 4, 7, 8), Rank.FOURTH),
            row(setOf(1, 2, 3, 7, 8, 9), Rank.FIFTH),
            row(setOf(7, 8, 9, 10, 11, 12), Rank.MISS),
        ) { lottoNumbers, expectedRank ->
            When("당첨 로또 번호가 ${lottoNumbers}일 때") {
                val rank = winningLotto.getRank(Lotto.from(lottoNumbers))

                Then("Rank는 ${expectedRank}가 반환된다") {
                    rank shouldBe expectedRank
                }
            }
        }
    }
})
