package lotto

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.inspectors.forAll
import io.kotest.matchers.shouldBe
import lotto.domain.Lotto
import lotto.domain.LottoNumber
import lotto.domain.Rank
import lotto.domain.WinningLotto

internal class WinningLottoTest : BehaviorSpec({

    Given("WinningLotto") {

        When("매칭 번호 개수가 각기 다른 로또가 주어졌을 때") {
            val winningLotto = WinningLotto(Lotto.of(listOf(1, 2, 3, 4, 5, 6)), LottoNumber(7))
            val lottoList = listOf(
                Lotto.of(listOf(1, 2, 3, 4, 5, 6)) to Rank.FIRST,
                Lotto.of(listOf(1, 2, 3, 4, 5, 7)) to Rank.SECOND_BONUS,
                Lotto.of(listOf(1, 2, 3, 4, 5, 8)) to Rank.SECOND,
                Lotto.of(listOf(1, 2, 3, 4, 7, 8)) to Rank.THIRD,
                Lotto.of(listOf(1, 2, 3, 7, 8, 9)) to Rank.FOURTH,
                Lotto.of(listOf(1, 2, 7, 8, 9, 10)) to Rank.MISS,
                Lotto.of(listOf(1, 7, 8, 9, 10, 11)) to Rank.MISS,
                Lotto.of(listOf(7, 8, 9, 10, 11, 12)) to Rank.MISS,
            )
            Then("번호 일치 개수에 따른 Rank를 반환") {
                lottoList.forAll { testcase ->
                    winningLotto.match(testcase.first) shouldBe testcase.second
                }
            }
        }

        When("로또 번호와 다른 보너스 번호가 주어지면") {
            val bonusNumber = LottoNumber(7)
            val winningLotto = WinningLotto(Lotto.of(listOf(1, 2, 3, 4, 5, 6)), bonusNumber)

            Then("WinningLotto가 생성된다.") {
                winningLotto.bonusNumber shouldBe bonusNumber
            }
        }

        When("로또 번호와 같은 보너스 번호가 주어지면") {
            val bonusNumbers = (1..6).map { LottoNumber(it) }
            Then("IllegalArgumentException 발생") {
                bonusNumbers.forAll { bonusNumber ->
                    shouldThrow<IllegalArgumentException> {
                        WinningLotto(Lotto.of(listOf(1, 2, 3, 4, 5, 6)), bonusNumber)
                    }
                }
            }
        }

        When("당첨번호 5개, 보너스가 일치하면") {
            val winningLotto = WinningLotto(Lotto.of(listOf(1, 2, 3, 4, 5, 6)), LottoNumber(7))
            val lottos = listOf(
                Lotto.of(listOf(1, 2, 3, 4, 5, 7)),
                Lotto.of(listOf(1, 2, 3, 4, 6, 7)),
                Lotto.of(listOf(1, 2, 3, 5, 6, 7)),
                Lotto.of(listOf(1, 2, 4, 5, 6, 7)),
                Lotto.of(listOf(1, 3, 4, 5, 6, 7)),
                Lotto.of(listOf(2, 3, 4, 5, 6, 7))
            )
            Then("IllegalArgumentException 발생") {
                lottos.forAll { lotto ->
                    winningLotto.match(lotto) shouldBe Rank.SECOND_BONUS
                }
            }
        }
    }
})
