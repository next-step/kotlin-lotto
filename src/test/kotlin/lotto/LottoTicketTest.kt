package lotto

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldNotBe

class LottoTicketTest : DescribeSpec({

    describe("constructor") {
        context("6개의 서로 다른 로또 번호들이 주어졌을 때") {
            it("로또 티켓이 생성된다") {
                val lottoNumbers = listOf(
                    LottoNumber(1),
                    LottoNumber(2),
                    LottoNumber(3),
                    LottoNumber(4),
                    LottoNumber(5),
                    LottoNumber(6),
                )

                LottoTicket(lottoNumbers) shouldNotBe null
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
})
