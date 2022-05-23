package lotto.domain

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe
import lotto.vo.Money

class LottoTicketsTest : DescribeSpec({

    describe("matching") {
        context("당첨 번호가 주어졌을 때 당첨 등수들을 확인한다") {
            val winningLotto = WinningLotto(`기본 로또 티켓(1~6)`(), LottoNumber(7))

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

            it("1등 1개, 4등 1개, 5등1개, 미당첨 2개") {
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
                    LottoRank.FOURTH,
                    LottoRank.FIFTH,
                    LottoRank.NOTHING,
                    LottoRank.NOTHING,
                )
                lottoTickets.matching(winningLotto) shouldBe LottoRanks(expected)
            }
        }
    }

    describe("amount") {
        context("로또 티켓을 1개 구매하였을 때") {
            it("1000 원을 반환한다") {
                val lottoTickets = LottoTickets(
                    listOf(`기본 로또 티켓(1~6)`())
                )

                lottoTickets.amount() shouldBe Money.of(1000)
            }
        }

        context("로또 티켓을 3개 구매하였을 때") {
            it("3000 원을 반환한다") {
                val lottoTickets = LottoTickets(
                    listOf(`기본 로또 티켓(1~6)`(), `기본 로또 티켓(1~6)`(), `기본 로또 티켓(1~6)`())
                )

                lottoTickets.amount() shouldBe Money.of(3000)
            }
        }
    }
})
