package lotto.domain

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.inspectors.forAll
import io.kotest.matchers.shouldBe
import lotto.vo.Money

class LottoShopTest : DescribeSpec({
    val lottoShop = LottoShop(
        object : LottoMachine {
            override fun generateAuto(): LottoTicket {
                return `기본 로또 티켓(1~6)`()
            }

            override fun generateManual(lottoNumbers: String): LottoTicket {
                return `기본 로또 티켓(1~6)`()
            }
        }
    )

    describe("buying") {
        context("로또 구입 금액과 수동 로또 번호가 주어졌을 때") {
            it("금액에 맞는 개수의 로또 티켓을 발급해야 한다") {
                listOf(
                    Money.of(1000) to 1,
                    Money.of(11_000) to 11
                ).forAll { (money, expectedCount) ->
                    val lottoTickets = lottoShop.buying(money)
                    lottoTickets.lottoTickets.size shouldBe expectedCount
                }
            }
        }
    }
})
