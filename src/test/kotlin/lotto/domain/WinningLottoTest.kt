package lotto.domain

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.inspectors.forAll
import io.kotest.matchers.shouldBe

class WinningLottoTest : DescribeSpec({

    describe("match") {
        val winningLotto = WinningLotto(`로또 티켓`(2..7), LottoNumber(8))
        context("로또 티켓이 주어졌을 때") {
            it("당첨결과를 반환한다") {
                listOf(
                    `로또 티켓`(1..6) to LottoRank.THIRD,
                    `로또 티켓`(2..7) to LottoRank.FIRST,
                    `로또 티켓`(3..8) to LottoRank.SECOND,
                    `로또 티켓`(4..9) to LottoRank.FOURTH,
                    `로또 티켓`(5..10) to LottoRank.FIFTH,
                    `로또 티켓`(6..11) to LottoRank.NOTHING,
                    `로또 티켓`(7..12) to LottoRank.NOTHING,
                    `로또 티켓`(8..13) to LottoRank.NOTHING,
                ).forAll { (lottoTicket, rank) ->
                    winningLotto.matching(lottoTicket) shouldBe rank
                }
            }
        }
    }
})
