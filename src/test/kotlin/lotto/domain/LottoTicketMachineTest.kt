package lotto.domain

import io.kotest.assertions.throwables.shouldThrowExactly
import io.kotest.core.spec.style.FreeSpec
import io.kotest.data.row
import io.kotest.inspectors.forAll
import io.kotest.matchers.collections.shouldHaveSize
import io.kotest.matchers.shouldBe
import java.math.BigDecimal

internal class LottoTicketMachineTest : FreeSpec({

    "로또 티켓을 발급할 수 있는 최소 금액보다 적게 주어지면 예외가 발생한다." - {
        listOf(
            1L,
            100L,
            999L
        ).forAll { value ->
            val money = Money(BigDecimal.valueOf(value))
            val exception = shouldThrowExactly<IllegalArgumentException> { LottoTicketMachine(money = money) }
            exception.message shouldBe "로또 구입을 위한 최소 금액은 ${lotto.domain.lottoticket.LottoTicket.PRICE.value} 입니다."
        }
    }

    "로또 티켓을 발급할 때마다 티켓만급의 금액이 차감된다." - {

        "수동 로또 티켓 발급" - {
            listOf(
                row(1_500L, 500L),
                row(1_000L, 0L),
                row(1_900L, 900L)
            ).forAll { (initMoney, afterMoney) ->
                "$initMoney 로 티켓을 발급하면 $afterMoney 가 남아 추가 발급이 불가능하다." {
                    val lottoTicketMachine = LottoTicketMachine(money = Money(BigDecimal.valueOf(initMoney)))
                    lottoTicketMachine.buyManualLottoTickets(listOf(1, 2, 3, 4, 5, 6))
                    val exception = shouldThrowExactly<IllegalStateException> {
                        lottoTicketMachine.buyManualLottoTickets(listOf(1, 2, 3, 4, 5, 6))
                    }

                    exception.message shouldBe "남은 금액 $afterMoney 으로 로또 티켓을 구입할 수 없습니다."
                }
            }
        }

        "자동 로또 티켓 발급" - {
            listOf(
                row(5_500L, 5),
                row(3_000L, 3),
                row(3_900L, 3)
            ).forAll { (initMoney, ticketCount) ->
                "$initMoney 금액으로 자동 티켓을 구매하면 $ticketCount 만큼 발급된다." {
                    val lottoTicketMachine = LottoTicketMachine(money = Money(BigDecimal.valueOf(initMoney)))
                    val autoTickets = lottoTicketMachine.buyAutoLottoTicketsUntilSpendAllMoney()

                    autoTickets.values.shouldHaveSize(ticketCount)
                }
            }
        }
    }

    "자동로또 티켓을 발급할 때 남은 금액이 부족하면 발급하지 않는다." - {
        listOf(
            row(1_500L, 500L),
            row(1_000L, 0L),
            row(1_900L, 900L)
        ).forAll { (initMoney, afterMoney) ->
            "$initMoney 로 티켓을 발급하면 $afterMoney 가 남아 추가 발급이 불가능하다." {
                val lottoTicketMachine = LottoTicketMachine(money = Money(BigDecimal.valueOf(initMoney)))
                lottoTicketMachine.buyManualLottoTickets(listOf(1, 2, 3, 4, 5, 6))
                val exception = shouldThrowExactly<IllegalStateException> {
                    lottoTicketMachine.buyAutoLottoTicketsUntilSpendAllMoney()
                }

                exception.message shouldBe "남은 금액 $afterMoney 으로 로또 티켓을 구입할 수 없습니다."
            }
        }
    }

    "자동 로또 티켓 발급시 6개의 번호를 가진 로또티켓을 발급한다." {
        // when
        val ticketSeller = LottoTicketMachine(money = lotto.domain.lottoticket.LottoTicket.PRICE)
        val lottoTicket = ticketSeller.buyAutoLottoTicketsUntilSpendAllMoney().values[0]

        // then
        lottoTicket.lottoNumbers.values.shouldHaveSize(6)
    }
})
