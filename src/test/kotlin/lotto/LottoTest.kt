package lotto

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe
import lotto.domain.Lotto

internal class LottoTest : BehaviorSpec({

    Given("Lotto") {
        val lotto = Lotto(listOf(1, 2, 3, 4, 5, 6))
        Then("로또는 6개의 번호를 가진다.") {
            lotto.lottoNumbers.size shouldBe 6
        }
    }
})
