package lotto

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.inspectors.forAll
import io.kotest.matchers.shouldBe
import lotto.domain.Lotto
import lotto.domain.Rank
import lotto.domain.WinningLotto

internal class WinningLottoTest : BehaviorSpec({

    Given("WinningLotto") {
        val winningLotto = WinningLotto(Lotto.of("1, 2, 3, 4, 5, 6"))

        When("매칭 번호 개수가 각기 다른 로또가 주어졌을 때") {
            val lottoList = listOf(
                Lotto.of("1, 2, 3, 4, 5, 6") to Rank.FIRST,
                Lotto.of("1, 2, 3, 4, 5, 7") to Rank.SECOND,
                Lotto.of("1, 2, 3, 4, 7, 8") to Rank.THIRD,
                Lotto.of("1, 2, 3, 7, 8, 9") to Rank.FOURTH,
                Lotto.of("1, 2, 7, 8, 9, 10") to Rank.MISS,
                Lotto.of("1, 7, 8, 9, 10, 11") to Rank.MISS,
                Lotto.of("7, 8, 9, 10, 11, 12") to Rank.MISS,
            )
            Then("번호 일치 개수에 따른 Rank를 반환") {
                lottoList.forAll { testcase ->
                    winningLotto.match(testcase.first) shouldBe testcase.second
                }
            }
        }
    }
})
