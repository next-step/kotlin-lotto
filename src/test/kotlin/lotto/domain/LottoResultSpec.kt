package lotto.domain

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class LottoResultSpec : FunSpec({
    context("당첨로또, 구매 로또, 티켓 가격으로 로또 결과가 생성된다") {
        val winningLotto = WinningLotto(LottoNumber(listOf(1, 2, 3, 4, 5, 6)), 7)
        val nonMatchedNumber = LottoNumber(listOf(8, 9, 10, 11, 12, 13))
        val fourthRankNumber = LottoNumber(listOf(1, 2, 3, 4, 44, 45))
        val ticket = LottoTicket(List(9) { nonMatchedNumber } + listOf(fourthRankNumber))
        val price = Amount(1000)

        val result = LottoResult.of(winningLotto, ticket, price)

        test("4등 1장, 댱첨 안된 9장에 대한 통계 생성") {
            result.rankCounts shouldBe mapOf(LottoRank.MISS to 9, LottoRank.FOURTH to 1).let(::LottoRankCounts)
        }

        test("총상금(50_000)을 구매 금액(10000)으로 나눈 수익률(5.00) 계산") {
            result.earningRate shouldBe EarningRate(5.00)
        }
    }
})
