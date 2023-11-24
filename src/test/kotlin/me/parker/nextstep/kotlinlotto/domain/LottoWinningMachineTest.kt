package me.parker.nextstep.kotlinlotto.domain

import io.kotest.assertions.throwables.shouldNotThrow
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.comparables.shouldBeGreaterThan
import io.kotest.matchers.shouldBe

class LottoWinningMachineTest : DescribeSpec({

    describe("로또 당첨 기계 생성") {
        context("지난 주 당첨 번호 로또 티켓과 구매한 로또 티켓 리스트가 주어지면") {
            it("정상적으로 LottoWinningMachine 객체를 생성한다.") {
                val lastWonLottoTicket = LottoTicket.manual(listOf(1, 2, 3, 4, 5, 6))
                val boughtLottoTickets = listOf(
                    LottoTicket.manual(listOf(1, 2, 3, 4, 5, 6)),
                    LottoTicket.manual(listOf(1, 2, 3, 4, 5, 7)),
                    LottoTicket.manual(listOf(1, 2, 3, 4, 8, 9)),
                    LottoTicket.manual(listOf(1, 2, 3, 10, 11, 12)),
                    LottoTicket.manual(listOf(1, 2, 13, 14, 15, 16)),
                    LottoTicket.manual(listOf(1, 17, 18, 19, 20, 21)),
                    LottoTicket.manual(listOf(22, 23, 24, 25, 26, 27)),
                    LottoTicket.manual(listOf(28, 29, 30, 31, 32, 33)),
                    LottoTicket.manual(listOf(34, 35, 36, 37, 38, 39)),
                    LottoTicket.manual(listOf(40, 41, 42, 43, 44, 45))
                )
                val bonusLottoNumber = LottoNumber(7)

                shouldNotThrow<Exception> {
                    LottoWinningMachine.result(lastWonLottoTicket, boughtLottoTickets, bonusLottoNumber)
                }
            }
        }
    }

    describe("result 메서드는") {
        context("지난 주 당첨 번호 로또 티켓과 구매한 로또 티켓 리스트가 주어지면") {
            it("당첨 결과를 반환한다. (각 등수당 당첨된 로또 티켓 갯수와 총 수익율을 계산한다.)") {
                val lastWonLottoTicket = LottoTicket.manual(listOf(1, 2, 3, 4, 5, 6))
                val boughtLottoTickets = listOf(
                    LottoTicket.manual(listOf(8, 21, 23, 41, 42, 43)),
                    LottoTicket.manual(listOf(3, 5, 11, 16, 32, 38)),
                    LottoTicket.manual(listOf(7, 11, 16, 35, 36, 44)),
                    LottoTicket.manual(listOf(1, 8, 11, 31, 41, 42)),
                    LottoTicket.manual(listOf(13, 14, 16, 38, 42, 45)),
                    LottoTicket.manual(listOf(7, 11, 30, 40, 42, 43)),
                    LottoTicket.manual(listOf(2, 13, 22, 32, 38, 45)),
                    LottoTicket.manual(listOf(23, 25, 33, 36, 39, 41)),
                    LottoTicket.manual(listOf(1, 3, 5, 14, 22, 45)),
                    LottoTicket.manual(listOf(5, 9, 38, 41, 43, 44)),
                    LottoTicket.manual(listOf(2, 8, 9, 18, 19, 21)),
                    LottoTicket.manual(listOf(13, 14, 18, 21, 23, 35)),
                    LottoTicket.manual(listOf(17, 21, 29, 37, 42, 45)),
                    LottoTicket.manual(listOf(3, 8, 27, 30, 35, 44)),
                )
                val bonusLottoNumber = LottoNumber(7)

                val result = LottoWinningMachine.result(lastWonLottoTicket, boughtLottoTickets, bonusLottoNumber)

                result.matchCount[LottoRank.FIRST] shouldBe 0
                result.matchCount[LottoRank.SECOND] shouldBe 0
                result.matchCount[LottoRank.THIRD] shouldBe 0
                result.matchCount[LottoRank.FOURTH] shouldBe 0
                result.matchCount[LottoRank.FIFTH] shouldBe 1
                result.matchCount[LottoRank.MISS] shouldBe 13
                result.profitRate shouldBeGreaterThan 0.35
            }

            it("당첨 결과를 반환 (2등 당첨 포함)") {
                val lastWonLottoTicket = LottoTicket.manual(listOf(1, 2, 3, 4, 5, 6))
                val boughtLottoTickets = listOf(
                    LottoTicket.manual(listOf(1, 2, 3, 4, 5, 6)),
                    LottoTicket.manual(listOf(1, 2, 3, 4, 5, 7)),
                    LottoTicket.manual(listOf(1, 2, 3, 4, 5, 8)),
                    LottoTicket.manual(listOf(1, 2, 3, 4, 8, 9)),
                    LottoTicket.manual(listOf(1, 2, 3, 10, 11, 12)),
                    LottoTicket.manual(listOf(1, 2, 13, 14, 15, 16)),
                    LottoTicket.manual(listOf(1, 17, 18, 19, 20, 21)),
                    LottoTicket.manual(listOf(22, 23, 24, 25, 26, 27)),
                    LottoTicket.manual(listOf(28, 29, 30, 31, 32, 33)),
                    LottoTicket.manual(listOf(34, 35, 36, 37, 38, 39)),
                    LottoTicket.manual(listOf(40, 41, 42, 43, 44, 45))
                )
                val bonusLottoNumber = LottoNumber(7)

                val result = LottoWinningMachine.result(lastWonLottoTicket, boughtLottoTickets, bonusLottoNumber)

                result.matchCount[LottoRank.FIRST] shouldBe 1
                result.matchCount[LottoRank.SECOND] shouldBe 1
                result.matchCount[LottoRank.THIRD] shouldBe 1
                result.matchCount[LottoRank.FOURTH] shouldBe 1
                result.matchCount[LottoRank.FIFTH] shouldBe 1
                result.matchCount[LottoRank.MISS] shouldBe 6
                result.profitRate shouldBe 184686.81818181818
            }
        }
    }
})
