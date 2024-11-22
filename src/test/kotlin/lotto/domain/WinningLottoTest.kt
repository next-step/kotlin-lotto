package lotto.domain

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.data.forAll
import io.kotest.data.row
import io.kotest.matchers.shouldBe
import io.kotest.matchers.shouldNotBe

class WinningLottoTest : BehaviorSpec({
    Given("당첨 번호가 주어졌을 때") {
        val validWinningNumbers = setOf(1, 2, 3, 4, 5, 6)

        When("당첨 로또 객체를 생성하면") {
            val winningLotto = WinningLotto(validWinningNumbers)

            Then("객체가 정상적으로 생성된다") {
                winningLotto shouldNotBe null
            }
        }
        When("잘못된 당첨 번호로 객체를 생성하면") {
            forAll(
                row(setOf(1, 2, 3, 4, 5), "당첨 번호는 반드시 6개여야 합니다."),
                row(setOf(1, 2, 3, 4, 5, 46), "당첨 번호는 1부터 45 사이여야 합니다."),
                row(setOf(-1, 2, 3, 4, 5, 6), "당첨 번호는 1부터 45 사이여야 합니다."),
            ) { invalidNumbers, expectedMessage ->
                Then("예외가 발생하고 메시지는 '$expectedMessage'이어야 한다") {
                    val exception =
                        shouldThrow<IllegalArgumentException> {
                            WinningLotto(invalidNumbers)
                        }
                    exception.message shouldBe expectedMessage
                }
            }
        }
    }

    Given("당첨 복권과 당첨 로또 번호가 주어졌을 때") {
        val winningLotto = WinningLotto(setOf(1, 2, 3, 4, 5, 6))

        forAll(
            row(setOf(1, 2, 3, 4, 5, 6), Rank.SIX),
            row(setOf(1, 2, 3, 4, 7, 8), Rank.FOUR),
            row(setOf(1, 2, 3, 7, 8, 9), Rank.THREE),
            row(setOf(7, 8, 9, 10, 11, 12), Rank.MISS),
        ) { lottoNumbers, expectedRank ->
            When("당첨 로또 번호가 ${lottoNumbers}일 때") {
                val rank = winningLotto.getRank(Lotto(lottoNumbers))

                Then("Rank는 ${expectedRank}가 반환된다") {
                    rank shouldBe expectedRank
                }
            }
        }
    }
})
