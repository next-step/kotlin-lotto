package lotto2.application

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class LottoShopTest : StringSpec({

    "로또 구매금액 7300원이 주어질 때, 로또 티켓 7장을 반환한다." {
        val 구매금액 = 7300
        val lottoTickets = LottoShop.buyLottoTickets(구매금액)

        lottoTickets.size() shouldBe 7
    }
})
