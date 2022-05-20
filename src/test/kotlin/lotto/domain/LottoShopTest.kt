package lotto.domain

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe
import lotto.vo.Money

class LottoShopTest : DescribeSpec({
    val lottoShop = LottoShop { `기본 로또 티켓(1~6)`() }

    describe("buying") {
        context("로또 구입 1_000원이 주어졌을 때") {
            it("1개의 로또 티켓을 발급해야 한다") {
                val lottoTickets = lottoShop.buying(Money.of(1_000))

                lottoTickets.lottoTickets.size shouldBe 1
            }

            context("로또 구입 11_000원이 주어졌을 때") {
                it("11개의 로또 티켓을 발급해야 한다") {
                    val lottoTickets = lottoShop.buying(Money.of(11_000))

                    lottoTickets.lottoTickets.size shouldBe 11
                }
            }
        }
    }
})
