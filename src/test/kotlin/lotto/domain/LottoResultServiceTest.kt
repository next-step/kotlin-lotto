package lotto.domain

import io.kotest.core.spec.style.StringSpec
import io.kotest.data.forAll
import io.kotest.data.row
import io.kotest.matchers.shouldBe

class LottoResultServiceTest : StringSpec({

    "로또 당첨 결과 개수 확인 테스트" {
        // given
        val luckyNumbers = listOf(1, 3, 5, 7, 9, 11)
        val lottoList = listOf(
            Lotto(listOf(2, 4, 6, 8, 10, 12)),
            Lotto(listOf(2, 4, 6, 8, 10, 12)),
            Lotto(listOf(2, 4, 6, 8, 10, 12)),
            Lotto(listOf(2, 4, 6, 8, 10, 12)),
        )
        // when
        val result = LottoResultService.inquireResult(luckyNumbers, lottoList)
        // then
        result.size shouldBe lottoList.size
    }

    "로또 번호 별 결과 테스트" {
        // given
        val luckyNumbers = listOf(1, 3, 5, 7, 9, 11)
        forAll(
            row(
                "당첨 개수가 0 일때",
                Lotto(listOf(2, 4, 6, 8, 10, 12)), LottoResult(0, 0)
            ),
            row(
                "당첨 개수가 1 일때",
                Lotto(listOf(1, 4, 6, 8, 10, 12)),
                LottoResult(1, 0)
            ),
            row(
                "당첨 개수가 2 일때",
                Lotto(listOf(1, 3, 6, 8, 10, 12)),
                LottoResult(2, 0)
            ),
            row(
                "당첨 개수가 3 일때",
                Lotto(listOf(1, 3, 5, 8, 10, 12)),
                LottoResult(3, 5000)
            ),
            row(
                "당첨 개수가 4 일때",
                Lotto(listOf(1, 3, 5, 7, 10, 12)),
                LottoResult(4, 50000)
            ),
            row(
                "당첨 개수가 5 일때",
                Lotto(listOf(1, 3, 5, 7, 9, 12)),
                LottoResult(5, 1500000)
            ),
            row(
                "당첨 개수가 6 일때",
                Lotto(listOf(1, 3, 5, 7, 9, 11)),
                LottoResult(6, 2000000000)
            )
        ) { title, inputLotto, expectedResult ->
            // when
            val result = LottoResultService.inquireResult(luckyNumbers, listOf(inputLotto))[0]
            // then
            result.hitCount shouldBe expectedResult.hitCount
            result.prizeMoney shouldBe expectedResult.prizeMoney
        }
    }
})
