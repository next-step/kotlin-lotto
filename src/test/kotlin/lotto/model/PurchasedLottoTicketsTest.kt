package lotto.model

import io.kotest.assertions.throwables.shouldNotThrowAny
import io.kotest.core.spec.DisplayName
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

@DisplayName("구매한 로또 티켓들")
class PurchasedLottoTicketsTest : StringSpec({

    "로또 티켓들과 개당 금액으로 생성" {
        shouldNotThrowAny {
            PurchasedLottoTickets(listOf(ONE_TO_SIX_LOTTO_TICKET), 1000)
        }
    }

    "당첨번호에 따른 로또 스코어 반환" {
        // given
        val oneToSixPurchasedLottoTickets =
            PurchasedLottoTickets(listOf(ONE_TO_SIX_LOTTO_TICKET, ONE_TO_SIX_LOTTO_TICKET), 1000)
        // when
        val lottoScore: LottoScore = oneToSixPurchasedLottoTickets scoreBy ONE_TO_SIX_LOTTO_TICKET
        // then
        lottoScore shouldBe LottoScore(listOf(LottoRank.FIRST, LottoRank.FIRST), 2000)
    }
})
