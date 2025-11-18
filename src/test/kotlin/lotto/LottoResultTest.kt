package lotto

import io.kotest.core.spec.style.FreeSpec
import io.kotest.matchers.shouldBe

class LottoResultTest : FreeSpec({
    "로또 당첨 결과 및 수익률 테스트" - {
        val winLotto = WinLotto("1 2 3 4 5 6")

        "당첨된 숫자가 하나도 없는 경우 MISS 1개 나오고 수익률은 0 이다." {
            val lottos = listOf(Lotto(listOf(7, 8, 9, 10, 11, 12)))
            val lottoResult = LottoResult(winLotto, lottos)

            // when
            lottoResult.process()

            // then
            lottoResult.matchMap shouldBe mapOf(Pair(Rank.MISS, 1))
            lottoResult.rateOfReturn shouldBe 0.0
        }

        "1등에 당첨된 경우 FIRST 1개 나오고 수익률은 2000000.0 이다" {
            val lottos = listOf(Lotto(listOf(1, 2, 3, 4, 5, 6)))
            val lottoResult = LottoResult(winLotto, lottos)

            // when
            lottoResult.process()

            // then
            lottoResult.matchMap shouldBe mapOf(Pair(Rank.FIRST, 1))
            lottoResult.rateOfReturn shouldBe 2000000.0
        }

        "1등에 당첨되었고, 로또를 2장 산 경우 FIRST 1개, MISS 1개 나오고 수익률은 1000000.0 이다" {
            val lottos = listOf(Lotto(listOf(1, 2, 3, 4, 5, 6)), Lotto(listOf(2, 5, 10, 11, 12, 13)))
            val lottoResult = LottoResult(winLotto, lottos)

            // when
            lottoResult.process()

            // then
            lottoResult.matchMap shouldBe mapOf(Pair(Rank.FIRST, 1), Pair(Rank.MISS, 1))
            lottoResult.rateOfReturn shouldBe 1000000.0
        }
    }
})
