package lotto.domain

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe
import lotto.domain.exception.LottoSizeMismatchException

class LottoTicketTest : DescribeSpec({
    describe("init 메서드 테스트") {
        context("로또 숫자가 6개가 주어질 때") {
            it("객체를 성공적으로 생성한다.") {
                val givenNumbers: Set<Int> = setOf(1, 2, 3, 4, 5, 6)
                val lottoTicket = LottoTicket(givenNumbers)

                lottoTicket.numbers shouldBe givenNumbers
            }
        }

        context("로또 숫자가 6개 이상 주어질 때") {
            it("예외를 던진다.") {
                shouldThrow<LottoSizeMismatchException> {
                    val givenNumbers: Set<Int> = setOf(1, 2, 3, 4, 5, 6, 7)
                    LottoTicket(givenNumbers)
                }
            }
        }

        context("로또 숫자가 6개 미만 주어질 때") {
            it("예외를 던진다.") {
                shouldThrow<LottoSizeMismatchException> {
                    val givenNumbers: Set<Int> = setOf(1, 2, 3, 4, 5)
                    LottoTicket(givenNumbers)
                }
            }
        }
    }

    describe("isMatch 메서드") {
        val givenWinningNumber: Set<Int> = setOf(1, 2, 3, 4, 5, 6)
        val givenLottoTicket = LottoTicket(setOf(1, 2, 3, 11, 22, 33))

        context("매치 카윤트가 일치하면") {
            it("true 를 반환한다.") {
                val givenMatchCount: Int = 3
                givenLottoTicket.isMatch(givenMatchCount, givenWinningNumber) shouldBe true
            }
        }

        context("매치 카윤트가 불일치하면") {
            it("false 를 반환한다.") {
                val givenMatchCount: Int = 2
                givenLottoTicket.isMatch(givenMatchCount, givenWinningNumber) shouldBe false
            }
        }
    }
})
