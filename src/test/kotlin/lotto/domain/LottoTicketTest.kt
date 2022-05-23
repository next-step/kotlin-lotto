package lotto.domain

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.DescribeSpec
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
            val lottoTicket = LottoTicket(`기본 로또 번호 목록(1~6)`())
            it("모든 번호의 수가 일치하면 6을 반환한다") {
                val otherLottoTicket = LottoTicket(
                    listOf(
                        LottoNumber(1),
                        LottoNumber(2),
                        LottoNumber(3),
                        LottoNumber(4),
                        LottoNumber(5),
                        LottoNumber(6),
                    )
                )

                lottoTicket.matching(otherLottoTicket) shouldBe 6
            }

            it("3개의 번호의 수가 일치하면 3을 반환한다") {
                val otherLottoTicket = LottoTicket(
                    listOf(
                        LottoNumber(1),
                        LottoNumber(2),
                        LottoNumber(3),
                        LottoNumber(7),
                        LottoNumber(8),
                        LottoNumber(9),
                    )
                )

                lottoTicket.matching(otherLottoTicket) shouldBe 3
            }

            it("하나도 일치하지 않으면 0을 반환한다") {
                val otherLottoTicket = LottoTicket(
                    listOf(
                        LottoNumber(7),
                        LottoNumber(8),
                        LottoNumber(9),
                        LottoNumber(10),
                        LottoNumber(11),
                        LottoNumber(12),
                    )
                )

                lottoTicket.matching(otherLottoTicket) shouldBe 0
            }
        }
    }

    describe("contains") {
        context("로또 번호가 주어졌을 때") {
            val lottoTicket = LottoTicket(
                listOf(
                    LottoNumber(1),
                    LottoNumber(2),
                    LottoNumber(3),
                    LottoNumber(4),
                    LottoNumber(5),
                    LottoNumber(6),
                )
            )
            it("포함되어 있는 경우 true 를 반환한다") {
                lottoTicket.contains(LottoNumber(5)) shouldBe true
            }

            it("포함되어 있지 않은 경우 false 를 반환한다") {
                lottoTicket.contains(LottoNumber(7)) shouldBe false
            }
        }
    }
})
