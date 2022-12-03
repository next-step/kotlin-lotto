package lotto.domain

import io.kotest.core.spec.style.FreeSpec
import io.kotest.matchers.shouldBe

class LottoTest : FreeSpec({

    "countHitNumbers" - {

        "당첨 로또 번호와 같은 갯수를 리턴한다." {
            val lotto = Lotto(listOf(1, 2, 3, 4, 5, 6))
            val luckLotto = listOf(1, 2, 3, 30, 31, 32)

            lotto.countHitNumbers(luckLotto) shouldBe 3
        }
    }
})
