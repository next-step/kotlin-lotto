package lotto.domain

import io.kotest.core.spec.style.FreeSpec
import io.kotest.matchers.collections.shouldContainAll
import io.kotest.matchers.shouldBe
import lotto.domain.LottoResult.FIFTH_PLACE
import lotto.domain.LottoResult.FIRST_PLACE
import lotto.domain.LottoResult.FOURTH_PLACE
import lotto.domain.LottoResult.LOSE
import lotto.domain.LottoResult.SECOND_PLACE
import lotto.domain.LottoResult.THIRD_PLACE
import java.math.BigDecimal

class LottoResultSummaryTest : FreeSpec({

    "당첨 정보를 조회한다." {
        val lottoResultSummary = LottoResultSummary(
            listOf(
                FIRST_PLACE,
                FOURTH_PLACE,
                FOURTH_PLACE,
                LOSE,
                LOSE
            )
        )

        lottoResultSummary.winResults().shouldContainAll(
            Pair(FOURTH_PLACE, 2), Pair(THIRD_PLACE, 0), Pair(SECOND_PLACE, 0), Pair(FIRST_PLACE, 1)
        )
    }

    "수익율을 계산한다." {
        val lottoResultSummary = LottoResultSummary(listOf(FIFTH_PLACE, LOSE, LOSE, LOSE, LOSE))
        lottoResultSummary.rateOfReturn() shouldBe BigDecimal("1.00")
    }
})
