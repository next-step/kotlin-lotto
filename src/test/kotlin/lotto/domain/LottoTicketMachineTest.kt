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
                row(3_500L, 500L),
                row(3_000L, 0L),
                row(3_900L, 900L)
            ).forAll { (initMoney, afterMoney) ->
                "$initMoney 로 티켓을 발급하면 $afterMoney 가 남아 추가 발급이 불가능하다." {
                    val lottoTicketMachine = LottoTicketMachine(money = Money(BigDecimal.valueOf(initMoney)))
                    repeat(3) { lottoTicketMachine.buyAutoLottoTicket() }

                    val exception = shouldThrowExactly<IllegalStateException> {
                        lottoTicketMachine.buyAutoLottoTicket()
                    }

                    exception.message shouldBe "남은 금액 $afterMoney 으로 로또 티켓을 구입할 수 없습니다."
                }
            }
        }
    }

    "자동 로또 티켓 발급시 6개의 번호를 가진 로또티켓을 발급한다." {
        // when
        val ticketSeller = LottoTicketMachine()
        val lottoTicket = ticketSeller.buyAutoLottoTicket()

        // then
        lottoTicket.lottoNumbers.values.shouldHaveSize(6)
    }

    "입력된 총 금액에 구입가능 금액만큼 나눠서 로또를 구매한다." - {
        listOf(
            row(1_000, 1),
            row(2_000, 2),
            row(5_500, 5),
            row(4_999, 4),
        ).forEach { (moneyValue, lottoCount) ->
            "'$moneyValue' 로는 '$lottoCount' 만큼 구매할 수 있다." {
                val lottoTicketMachine = LottoTicketMachine(money = Money(moneyValue.toBigDecimal()))
                repeat(lottoCount) { lottoTicketMachine.buyAutoLottoTicket() }
                shouldThrowExactly<IllegalStateException> { lottoTicketMachine.buyAutoLottoTicket() }
            }
        }
    }
})
