package lotto.domain.lotto

import io.kotest.core.spec.style.FunSpec
import io.kotest.datatest.withData
import io.kotest.matchers.collections.shouldHaveSize
import lotto.domain.lotto.ticket.LottoTicket
import org.junit.jupiter.api.assertThrows

class LottoTest : FunSpec({
    context("비용을 입력받아서, 로또 생성이 가능하다") {
        withData(
            nameFn = { "Lotto($it)" },
            listOf(
                14000,
                15000,
                16000,
                17000,
                18000,
            )
        ) { cost ->
            val lotto = Lotto(cost)

            val expectedTicketCount = cost.div(lotto.lottoTicketPrice.price)
            lotto.lottoTicketList.list shouldHaveSize expectedTicketCount

            lotto.lottoTicketList.list.toSet() shouldHaveSize expectedTicketCount

            lotto.lottoTicketList.list.map { lottoTicket ->
                lottoTicket.lottoNumberList.map { lottoNumber ->
                    lottoNumber.number
                }
            }.toSet() shouldHaveSize expectedTicketCount

            lotto.lottoTicketList.list.forEach { lottoTicket ->
                lottoTicket.lottoNumberList.map { lottoNumber ->
                    lottoNumber.number
                }.toSet() shouldHaveSize LottoTicket.TOTAL_COUNT_LOTTO_NUMBER
            }
        }
    }

    context("비용, 가격을 입력받아서, 로또 생성이 가능하다.") {
        withData(
            nameFn = { "Lotto(${it.first},${it.second})" },
            listOf(
                14000 to 1000,
                14000 to 2000,
                14000 to 3000,
                14000 to 4000,
                14000 to 5000,
            )
        ) { (cost, price) ->
            val lotto = Lotto(cost, price)

            val expectedTicketCount = cost.div(price)
            lotto.lottoTicketList.list shouldHaveSize expectedTicketCount

            lotto.lottoTicketList.list.toSet() shouldHaveSize expectedTicketCount

            lotto.lottoTicketList.list.map { lottoTicket ->
                lottoTicket.lottoNumberList.map { lottoNumber ->
                    lottoNumber.number
                }
            }.toSet() shouldHaveSize expectedTicketCount

            lotto.lottoTicketList.list.forEach { lottoTicket ->
                lottoTicket.lottoNumberList.map { lottoNumber ->
                    lottoNumber.number
                }.toSet() shouldHaveSize LottoTicket.TOTAL_COUNT_LOTTO_NUMBER
            }
        }
    }

    context("비용 혹은 가격이 0보다 같거나 작으면, 로또 생성이 불가능하다") {
        withData(
            nameFn = { "${it.first}, ${it.second}" },
            listOf(
                14000 to 0,
                0 to 2000,
                14000 to -2000,
                -14000 to 4000,
                -14000 to -1000
            )
        ) { (cost, price) ->
            assertThrows<IllegalArgumentException> { Lotto(cost, price) }
        }
    }

    context("비용이 가격보다 작으면, 로또 생성이 불가능하다") {
        withData(
            nameFn = { "${it.first} < ${it.second}" },
            listOf(
                900 to 1000,
                1800 to 2000,
                2999 to 3000,
                3999 to 4000,
                10 to 5000,
            )
        ) { (cost, price) ->
            assertThrows<IllegalArgumentException> { Lotto(cost, price) }
        }
    }
})
