package lotto
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.collections.shouldContainAll
import io.kotest.matchers.collections.shouldHaveSize
import io.kotest.matchers.shouldBe

class LottoTicketBundleTest : FunSpec({
    context("여러 개의 로또 티켓 당첨 비교") {
        test("여러 개의 로또 티켓을 당첨 번호와 비교할 수 있다.") {
            val winningNumber = WinningNumber.from(numbers = listOf(5, 10, 15, 25, 35, 45))
            val lottoNumber = LottoNumber.manualGenerate(numbers = listOf(5, 10, 15, 20, 25, 30))
            val tickets = listOf(
                LottoTicket.purchase(1000, lottoNumber),
                LottoTicket.purchase(1000, lottoNumber),
                LottoTicket.purchase(1000, lottoNumber),
            )
            val sut = LottoTicketBundle(tickets = tickets)
            sut.match(winningNumber = winningNumber)
            sut.getTickets().forEach { ticket ->
                ticket.status shouldBe LottoTicketStatus.WIN
                ticket.matchCount shouldBe 4
            }
        }
    }

    context("여러 개의 로또 티켓 구매") {
        context("지불 금액을 전달하면") {
            test("여러 개의 티켓을 한 번에 구매할 수 있다.") {
                val actual = LottoTicketBundle.purchase(payment = 14500)
                actual.getTickets() shouldHaveSize 14
            }

            context("수동 번호를 함께 전달하면") {
                test("수동 번호를 포함한 여러 개의 티켓을 한 번에 구매할 수 있다.") {
                    val manualNumbers = listOf(
                        LottoNumber.manualGenerate(listOf(5, 10, 15, 20, 25, 30)),
                        LottoNumber.manualGenerate(listOf(5, 10, 20, 30, 40, 45))
                    )

                    val actual = LottoTicketBundle.purchase(payment = 14500, manualNumbers = manualNumbers)
                    actual.getTickets() shouldHaveSize 14
                    actual.getTickets().map { it.lottoNumber } shouldContainAll manualNumbers
                }
            }
        }
    }

    context("당첨 티켓 조회") {
        test("여러 개의 티켓에서 당첨 티켓만을 조회할 수 있다.") {
            val winningNumber = WinningNumber.from(listOf(5, 10, 15, 20, 30, 40))
            val manualNumbers = listOf(
                LottoNumber.manualGenerate(listOf(5, 10, 15, 20, 25, 30)),
                LottoNumber.manualGenerate(listOf(5, 10, 20, 30, 40, 45))
            )

            val sut = LottoTicketBundle.purchase(payment = 2000, manualNumbers)
            sut.match(winningNumber = winningNumber)
            val actual = sut.getWinningTickets()

            actual shouldHaveSize 2
        }
    }
})
