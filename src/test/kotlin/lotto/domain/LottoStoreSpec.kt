package lotto.domain

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe

class LottoStoreSpec : BehaviorSpec({

    given("입력 받은 금액이 있을때") {
        `when`("로또를 구매하면") {
            val lottoStore = LottoStore()
            val lottoTickets = lottoStore.buyLottoTicket(14000)

            then("구매한 로또의 수는 14개이다.") {
                lottoTickets.size shouldBe 14
            }
        }
    }
})
