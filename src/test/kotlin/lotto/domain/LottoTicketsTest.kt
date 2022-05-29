package lotto.domain

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.inspectors.forAll
import io.kotest.matchers.shouldBe
import lotto.vo.Money

class LottoTicketsTest : DescribeSpec({

    describe("matching") {
        context("당첨 번호가 주어졌을 때 당첨 등수들을 확인한다") {
            val winningLotto = WinningLotto(`기본 로또 티켓(1~6)`(), LottoNumber(7))

            listOf(
                LottoTickets(listOf(`기본 로또 티켓(1~6)`())) to LottoRanks(listOf(LottoRank.FIRST)),
                LottoTickets(listOf(`기본 로또 티켓(1~6)`(), `로또 티켓`(2..7))) to LottoRanks(
                    listOf(
                        LottoRank.FIRST, LottoRank.SECOND
                    )
                ),
                LottoTickets(
                    listOf(
                        `기본 로또 티켓(1~6)`(),
                        `로또 티켓`(3..8),
                        `로또 티켓`(4..9),
                        `로또 티켓`(5..10),
                        `로또 티켓`(7..12),
                    )
                ) to LottoRanks(
                    listOf(
                        LottoRank.FIRST,
                        LottoRank.FOURTH,
                        LottoRank.FIFTH,
                        LottoRank.NOTHING,
                        LottoRank.NOTHING,
                    )
                )
            ).forAll { (lottoTickets, lottoRanks) ->
                lottoTickets.matching(winningLotto) shouldBe lottoRanks
            }
        }
    }

    describe("amount") {
        context("로또 티켓을 n개 구매하였을 때") {
            it("1000*n원을 반환한다") {
                listOf(
                    LottoTickets(listOf(`기본 로또 티켓(1~6)`())) to Money.of(1_000),
                    LottoTickets(listOf(`기본 로또 티켓(1~6)`(), `기본 로또 티켓(1~6)`(), `기본 로또 티켓(1~6)`())) to Money.of(3_000)
                ).forAll { (lottoTickets, buyingAmount) ->
                    lottoTickets.amount() shouldBe buyingAmount
                }
            }
        }
    }
})
