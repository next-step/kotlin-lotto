package lotto.domain

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class LottoResultTest : StringSpec({
    "로또 당첨 개수가 3개 미만, 6개 초과면 결과에 추가하지 않는다." {
        listOf(0, 1, 2, 7).forEach { count ->
            // given
            val lottoResult = LottoResult()

            // when
            lottoResult.add(count)

            // then
            lottoResult.result shouldBe mapOf(
                LottoMatchCount.THREE to 0,
                LottoMatchCount.FOUR to 0,
                LottoMatchCount.FIVE to 0,
                LottoMatchCount.SIX to 0,
            )
        }
    }

    "로또 당첨 개수가 3~6개면 결과에 추가한다." {
        listOf(3, 4, 5, 6).forEach { count ->
            // given
            val lottoResult = LottoResult()

            // when
            lottoResult.add(count)

            // then
            val lottoMatchCount = LottoMatchCount.of(count)
            lottoResult.result[lottoMatchCount] shouldBe 1
        }
    }
})
