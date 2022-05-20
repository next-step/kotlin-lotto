package lotto.domain

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

class LottoTicketsTest : DescribeSpec({

    describe("matching") {
        context("당첨 번호가 주어졌을 때 당첨 등수들을 확인한다") {
            val winningLotto = `기본 로또 티켓(1~6)`()

            it("1등") {
                val lottoTickets = LottoTickets(
                    listOf(`기본 로또 티켓(1~6)`())
                )

                lottoTickets.matching(winningLotto) shouldBe LottoRanks(listOf(LottoRank.FIRST))
            }

            it("1등 1개, 2등 1개") {
                val lottoTickets = LottoTickets(
                    listOf(
                        `기본 로또 티켓(1~6)`(),
                        `로또 티켓`(2..7)
                    )
                )

                lottoTickets.matching(winningLotto) shouldBe LottoRanks(listOf(LottoRank.FIRST, LottoRank.SECOND))
            }

            it("1등 1개, 3등 1개, 4등1개, 미당첨 2개") {
                val lottoTickets = LottoTickets(
                    listOf(
                        `기본 로또 티켓(1~6)`(),
                        `로또 티켓`(3..8),
                        `로또 티켓`(4..9),
                        `로또 티켓`(5..10),
                        `로또 티켓`(7..12),
                    )
                )

                val expected = listOf(
                    LottoRank.FIRST,
                    LottoRank.THIRD,
                    LottoRank.FOURTH,
                    LottoRank.NOTTING,
                    LottoRank.NOTTING,
                )
                lottoTickets.matching(winningLotto) shouldBe LottoRanks(expected)
            }
        }
    }
})
