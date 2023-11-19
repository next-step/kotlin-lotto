package lotto.domain

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe
import lotto.domain.vo.RankFrequency
import lotto.presentation.controller.LottoResult

class LottoResultSpec : BehaviorSpec({

    given("로또 결과") {
        `when`("확정 되었을때") {
            val lottoResult = LottoResult(
                mapOf(
                    Rank.SECOND to RankFrequency.of(1),
                    Rank.MISS to RankFrequency.of(1)
                )
            )

            then("EarningRate를 계산할 수 있다.") {
                lottoResult.getEarningRate() shouldBe 15000.0
            }
        }
    }

    given("로또 결과가 주어졌을때") {
        val lottoResult = LottoResult(
            mapOf(
                Rank.SECOND to RankFrequency.of(1),
                Rank.MISS to RankFrequency.of(1)
            )
        )

        `when`("로또 결과를 response 로 뷰에 보내기 위해 변환하면") {
            // val evaluateResponse = EvaluateResponse.from(lottoResult)
            val resultTableForResponse = lottoResult.getResultTable()

            then("전체 결과 구조를 확인할 수 있다.") {
                resultTableForResponse[1][0] shouldBe 5
                resultTableForResponse[1][1] shouldBe 30_000_000
                resultTableForResponse[1][2] shouldBe 1
            }
        }
    }
})
