package lotto

import io.kotest.core.spec.style.FreeSpec
import io.kotest.matchers.shouldBe
import lotto.domin.LottoWinningAmount
import lotto.domin.LottoWinningAmount.Companion.matchWinningLotto
import lotto.domin.MatchCount

class LottoWinningAmount : FreeSpec({

    "matchWinningLotto" - {

        "일치하는 로또의 개수와 가격을 반환해야한다." {
            val containList = listOf(MatchCount(3, 0), MatchCount(5, 0))
            val result = matchWinningLotto(containList)

            result[LottoWinningAmount.FIFTH] shouldBe 1
            result[LottoWinningAmount.FOURTH] shouldBe 0
            result[LottoWinningAmount.THIRD] shouldBe 1
            result[LottoWinningAmount.SECOND] shouldBe 0
            result[LottoWinningAmount.FIRST] shouldBe 0
        }
    }
})
