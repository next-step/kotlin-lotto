package lotto.domain

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

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
                val exception = shouldThrow<IllegalArgumentException> {
                    val givenNumbers: Set<Int> = setOf(1, 2, 3, 4, 5, 6, 7)
                    LottoTicket(givenNumbers)
                }
                exception.message shouldBe "6자리 로또 티켓을 입력해주세요."
            }
        }

        context("로또 숫자가 6개 미만 주어질 때") {
            it("예외를 던진다.") {
                val exception = shouldThrow<IllegalArgumentException> {
                    val givenNumbers: Set<Int> = setOf(1, 2, 3, 4, 5)
                    LottoTicket(givenNumbers)
                }
                exception.message shouldBe "6자리 로또 티켓을 입력해주세요."
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
