package lotto

import io.kotest.core.spec.style.FreeSpec
import io.kotest.matchers.shouldBe
import lotto.domin.LottoWinningAmount.Companion.matchWinningLotto

class LottoWinningAmount : FreeSpec({

    "matchWinningLotto" - {

        "일치하는 로또의 개수와 가격을 반환해야한다." {
            val containList = listOf(1, 2, 3, 4, 5, 6)
            val result = matchWinningLotto(containList)

            result.values.forEach {  count->
                count shouldBe 1
            }
        }
    }
})
