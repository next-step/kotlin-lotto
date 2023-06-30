package lotto

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.inspectors.forAll
import io.kotest.matchers.collections.shouldContainAll
import io.kotest.matchers.shouldBe
import lotto.domain.*

internal class LottoListTest : BehaviorSpec({

    Given("LottoList") {
        When("Rank 별로 각 1개씩 일치하는 상활일 때") {
            val winningLotto = WinningLotto(Lotto.of(listOf(1, 2, 3, 4, 5, 6)), LottoNumber(7))
            val lottos = listOf(
                Lotto.of(listOf(1, 2, 3, 4, 5, 6)),
                Lotto.of(listOf(1, 2, 3, 4, 5, 7)),
                Lotto.of(listOf(1, 2, 3, 4, 7, 8)),
                Lotto.of(listOf(1, 2, 3, 7, 8, 9)),
                Lotto.of(listOf(1, 2, 7, 8, 9, 10)),
            )
            Then("일치하는 번호 수에 맞는 Rank와 개수를 가진 LottoResult가 반환된다.") {
                val actual = LottoList(lottos).getResult(winningLotto)
                println(actual.result.keys)
                actual.result.keys.shouldContainAll(*Rank.values())
                actual.result.values.forAll { it shouldBe 1 }
            }
        }
    }
})
