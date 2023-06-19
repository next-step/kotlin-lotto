package lotto.domain

import java.math.BigDecimal
import io.kotest.core.spec.style.FreeSpec
import io.kotest.matchers.collections.shouldContainAll
import io.kotest.matchers.shouldBe
import lotto.domain.LottoResult.*

class LottoResultSummaryTest : FreeSpec({

    "당첨 정보를 조회한다." {
        val lottoResultSummary = LottoResultSummary(
            listOf(FIRST_PLACE,
                FOURTH_PLACE,
                FOURTH_PLACE,
                LOSE,
                LOSE)
        )

        lottoResultSummary.winResults().shouldContainAll(
            Pair(FOURTH_PLACE, 2), Pair(THIRD_PLACE, 0), Pair(SECOND_PLACE, 0), Pair(FIRST_PLACE, 1)
        )
    }

    "수익율을 계산한다." {
        val lottoResultSummary = LottoResultSummary(listOf(FOURTH_PLACE, LOSE, LOSE, LOSE, LOSE))
        lottoResultSummary.rateOfReturn() shouldBe BigDecimal("1.00")
    }

})
