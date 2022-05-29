package lotto.domain

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.inspectors.forAll
import io.kotest.matchers.shouldBe
import io.kotest.matchers.shouldNotBe

class LottoTicketTest : DescribeSpec({

    describe("constructor, of") {
        context("6개의 서로 다른 로또 번호들이 주어졌을 때") {
            it("로또 티켓이 생성된다") {
                val lottoNumbers = `기본 로또 번호 목록(1~6)`()

                LottoTicket(lottoNumbers) shouldNotBe null
            }

            it("문자열과 구분자로 구성된 경우 로또 티켓이 생성된다") {
                val lottoNumbers = "1, 2, 3, 4, 5, 6"

                LottoTicket.of(lottoNumbers) shouldNotBe null
            }

            it("숫자 목록으로 구성된 경우 로또 티켓이 생성 된다") {
                val lottoNumbers = listOf(1, 2, 3, 4, 5, 6)

                LottoTicket.of(lottoNumbers) shouldNotBe null
            }
        }

        context("로또 번호가 주어지지 않았을 때") {
            it("IllegalArgumentException 예외가 발생한다") {
                shouldThrow<IllegalArgumentException> { LottoTicket(emptyList()) }
            }
        }

        context("6개가 아닌 로또 번호들이 주어졌을 때") {
            it("IllegalArgumentException 예외가 발생한다") {
                val lottoNumbers = listOf(
                    LottoNumber(1), LottoNumber(2)
                )

                shouldThrow<IllegalArgumentException> { LottoTicket(lottoNumbers) }
            }
        }

        context("6개의 로또 번호 중 같은 번호가 있을 경우") {
            it("IllegalArgumentException 예외가 발생한다") {
                val lottoNumbers = listOf(
                    LottoNumber(1),
                    LottoNumber(2),
                    LottoNumber(3),
                    LottoNumber(4),
                    LottoNumber(5),
                    LottoNumber(5),
                )

                shouldThrow<IllegalArgumentException> { LottoTicket(lottoNumbers) }
            }
        }
    }

    describe("matching") {
        context("두 로또 티켓이 주어졌을 때") {
            val lottoTicket = `기본 로또 티켓(1~6)`()

            it("일치하는 번호의 수를 반환한다") {
                listOf(
                    `기본 로또 티켓(1~6)`() to 6,
                    `로또 티켓`(4..9) to 3,
                    `로또 티켓`(7..12) to 0,
                ).forAll { (otherTicket, matchCount) ->
                    lottoTicket.matching(otherTicket) shouldBe matchCount
                }
            }
        }
    }

    describe("contains") {
        context("로또 번호가 주어졌을 때") {
            val lottoTicket = `기본 로또 티켓(1~6)`()

            it("포함되어 있는 경우 true 를 반환한다") {
                lottoTicket.contains(LottoNumber(5)) shouldBe true
            }

            it("포함되어 있지 않은 경우 false 를 반환한다") {
                lottoTicket.contains(LottoNumber(7)) shouldBe false
            }
        }
    }
})
