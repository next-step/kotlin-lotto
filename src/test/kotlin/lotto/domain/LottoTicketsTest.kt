package lotto.domain

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

class LottoTicketsTest : DescribeSpec({
    describe("init 메서드 테스트") {
        context("로또 티켓 개수가 1개 이상 일 떄,") {
            val givenLottoTickets = listOf(LottoTicket(setOf(1, 2, 3, 4, 5, 6)))

            it("객체를 생성한다.") {
                val lottoTickets = LottoTickets(givenLottoTickets)
                lottoTickets.lottoTickets shouldBe givenLottoTickets
            }
        }

        context("로또 티켓 개수가 0개 일 때,") {
            it("예외를 던진다.") {
                shouldThrow<IllegalArgumentException> {
                    LottoTickets(listOf())
                }
            }
        }
    }

    describe("getMatchCount 메서드") {
        val givenLottoTicket1 = LottoTicket(setOf(7, 9, 11, 34, 35, 43))
        val givenLottoTicket2 = LottoTicket(setOf(5, 6, 9, 13, 34, 35))
        val givenLottoTickets = LottoTickets(listOf(givenLottoTicket1, givenLottoTicket2))

        context("로또 랭크가 THIRD 일 때") {
            val givenLottoWinningNumber = LottoWinningNumber(setOf(5, 6, 9, 13, 34, 1), 2)

            it("매치 카운트를 구한다.") {
                val matchCount = givenLottoTickets.getMatchCount(LottoRank.THIRD, givenLottoWinningNumber)

                matchCount shouldBe 1
            }
        }

        context("로또랭크가 SECOND 일 때") {
            it("보너스 번호가 동일하면 매치 카운트를 한다.") {
                val givenLottoWinningNumber = LottoWinningNumber(setOf(5, 6, 9, 13, 34, 1), 35)
                val matchCount = givenLottoTickets.getMatchCount(LottoRank.SECOND, givenLottoWinningNumber)

                matchCount shouldBe 1
            }

            it("보너스 번호가 동일하지 않다면 카운트하지 않는다.") {
                val givenLottoWinningNumber = LottoWinningNumber(setOf(5, 6, 9, 13, 34, 1), 36)
                val matchCount = givenLottoTickets.getMatchCount(LottoRank.SECOND, givenLottoWinningNumber)

                matchCount shouldBe 0
            }
        }
    }
})
