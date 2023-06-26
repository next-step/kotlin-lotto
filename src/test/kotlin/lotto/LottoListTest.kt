package lotto

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.inspectors.forAll
import io.kotest.matchers.shouldBe
import lotto.domain.Lotto
import lotto.domain.LottoList
import lotto.domain.LottoNumbers

internal class LottoListTest : BehaviorSpec({

    Given("LottoList") {
        When("각 로또가 0~6개 일치하는 상활일 때") {
            val previousLottoNumbers = LottoNumbers(listOf(1, 2, 3, 4, 5, 6))
            val lottos = listOf(
                LottoNumbers(listOf(1, 2, 3, 4, 5, 6)),
                LottoNumbers(listOf(1, 2, 3, 4, 5, 7)),
                LottoNumbers(listOf(1, 2, 3, 4, 7, 8)),
                LottoNumbers(listOf(1, 2, 3, 7, 8, 9)),
                LottoNumbers(listOf(1, 2, 7, 8, 9, 10)),
                LottoNumbers(listOf(1, 7, 8, 9, 10, 11)),
                LottoNumbers(listOf(7, 8, 9, 10, 11, 12))
            ).map { Lotto(it) }
            Then("일치하는 번호 수에 맞는 로또들이 묶인 LottoResult가 반환된다.") {
                val actual = LottoList(lottos).getResult(previousLottoNumbers)
                actual.result.keys shouldBe (0..6).toSet()
                actual.result.values.flatMap { it.lottos } shouldBe lottos
                actual.result.values.forAll { it.lottos.size shouldBe 1 }
            }
        }
    }
})
