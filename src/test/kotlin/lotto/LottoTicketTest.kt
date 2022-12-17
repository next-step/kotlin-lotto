package lotto

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.collections.shouldContainExactly
import io.kotest.matchers.shouldBe
import io.kotest.matchers.shouldNotBe
import org.junit.jupiter.api.assertThrows
import java.lang.IllegalArgumentException

class LottoTicketTest : FunSpec({
    context("로또 티켓 구매") {
        context("지불 금액") {
            test("1000원 초과하면 티켓을 구매할 수 없다.") {
                assertThrows<IllegalArgumentException> { LottoTicket.purchase(payment = 1500) }
            }

            test("1000원 미만이면 티켓을 구매할 수 없다.") {
                assertThrows<IllegalArgumentException> { LottoTicket.purchase(payment = 500) }
            }

            test("1000원이면 티켓을 구매할 수 있다.") {
                val actual = LottoTicket.purchase(payment = 1000)
                actual shouldNotBe null
                actual.lottoNumber shouldNotBe null
                actual.status shouldBe LottoTicketStatus.WAITING
                actual.matchCount shouldBe 0
            }
        }

        context("수동 로또 번호") {
            context("로또 번호를 함께 전달하면") {
                test("수동 로또 번호로도 구매할 수 있다.") {
                    val lottoNumber = LottoNumber.manualGenerate(numbers = listOf(5, 10, 15, 20, 25, 30))

                    val actual = LottoTicket.purchase(payment = 1000, manualNumber = lottoNumber)

                    actual.lottoNumber.numbers shouldContainExactly lottoNumber.numbers
                    actual.status shouldBe LottoTicketStatus.WAITING
                    actual.matchCount shouldBe 0
                }
            }
        }
    }

    context("로또 티켓 당첨 비교") {
        context("당첨 번호를 전달하면") {
            test("로또 티켓의 당첨 여부와 맞춘 갯수가 정해진다.") {
                val winningNumber = WinningNumber.from(numbers = listOf(5, 10, 15, 22, 33, 44))
                val lottoNumber = LottoNumber.manualGenerate(numbers = listOf(5, 10, 15, 20, 25, 30))
                val actual = LottoTicket.purchase(payment = 1000, lottoNumber)

                actual.match(winningNumber = winningNumber)

                actual.status shouldBe LottoTicketStatus.WIN
                actual.matchCount shouldBe 3
            }
        }
    }
})
