package lotto

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

                lottoTickets.matching(winningLotto) shouldBe listOf(LottoRanking.FIRST)
            }

            it("1등 1개, 2등 1개") {
                val lottoTickets = LottoTickets(
                    listOf(
                        `기본 로또 티켓(1~6)`(),
                        `로또 티켓`(2..7)
                    )
                )

                lottoTickets.matching(winningLotto) shouldBe listOf(LottoRanking.FIRST, LottoRanking.SECOND)
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
                    LottoRanking.FIRST,
                    LottoRanking.THIRD,
                    LottoRanking.FOURTH,
                    LottoRanking.NOTTING,
                    LottoRanking.NOTTING,
                )
                lottoTickets.matching(winningLotto) shouldBe expected
            }
        }
    }
})
