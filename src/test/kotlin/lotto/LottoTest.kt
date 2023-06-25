package lotto

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.inspectors.forAll
import io.kotest.matchers.shouldBe
import lotto.domain.Lotto
import lotto.domain.LottoNumbers

internal class LottoTest : BehaviorSpec({

    Given("Lotto") {
        val lotto = Lotto(LottoNumbers(listOf(1, 2, 3, 4, 5, 6)))
        Then("로또는 6개의 번호를 가진다.") {
            lotto.lottoNumbers.numbers.size shouldBe 6
        }

        When("previousLottoNumbers가 주어졌을 때") {
            val previousLottoNumbersList = listOf(
                LottoNumbers(listOf(1, 2, 3, 4, 5, 6)) to 6,
                LottoNumbers(listOf(1, 2, 3, 4, 5, 7)) to 5,
                LottoNumbers(listOf(1, 2, 3, 4, 7, 8)) to 4,
                LottoNumbers(listOf(1, 2, 3, 7, 8, 9)) to 3,
                LottoNumbers(listOf(1, 2, 7, 8, 9, 10)) to 2,
                LottoNumbers(listOf(1, 7, 8, 9, 10, 11)) to 1,
                LottoNumbers(listOf(7, 8, 9, 10, 11, 12)) to 0,
            )
            Then("번호 일치 개수를 반환") {
                previousLottoNumbersList.forAll { testcase ->
                    lotto.countMatchNumbers(testcase.first) shouldBe testcase.second
                }
            }
        }
    }
})
