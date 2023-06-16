package lotto.model

import io.kotest.assertions.assertSoftly
import io.kotest.assertions.throwables.shouldNotThrowAny
import io.kotest.core.spec.DisplayName
import io.kotest.core.spec.style.StringSpec
import io.kotest.inspectors.forAll
import io.kotest.matchers.shouldBe
import lotto.model.LottoTicket.Companion.automaticSize
import lotto.model.LottoTicket.Companion.manualSize

@DisplayName("로또 티켓")
class LottoTicketTest : StringSpec({

    "로또와 티켓 타입으로 생성" {
        shouldNotThrowAny {
            LottoTicket(ONE_TO_SIX_LOTTO, TicketType.AUTOMATIC)
        }
    }

    "로또와 일치하는 개수 반환" {
        LottoTicket(ONE_TO_SIX_LOTTO, TicketType.AUTOMATIC) matchedCountBy ONE_TO_SIX_LOTTO shouldBe 6
    }

    "로또 티켓의 로또 번호 포함 여부 확인" {
        listOf(
            LottoNumber(1) to true,
            LottoNumber(6) to true,
            LottoNumber(7) to false,
        ).forAll {
            (it.first in LottoTicket(ONE_TO_SIX_LOTTO, TicketType.AUTOMATIC)) shouldBe it.second
        }
    }

    "수동 로또 개수" {
        // given
        val twoManualThreeAutoMatic: Collection<LottoTicket> = listOf(
            LottoTicket(ONE_TO_SIX_LOTTO, TicketType.MANUAL),
            LottoTicket(ONE_TO_SIX_LOTTO, TicketType.MANUAL),
            LottoTicket(ONE_TO_SIX_LOTTO, TicketType.AUTOMATIC),
            LottoTicket(ONE_TO_SIX_LOTTO, TicketType.AUTOMATIC),
            LottoTicket(ONE_TO_SIX_LOTTO, TicketType.AUTOMATIC),
        )
        // when & then
        assertSoftly(twoManualThreeAutoMatic) {
            manualSize shouldBe 2
            automaticSize shouldBe 3
        }
    }
})

val ONE_TO_SIX_AUTO_LOTTO_TICKET = LottoTicket(ONE_TO_SIX_LOTTO, TicketType.AUTOMATIC)
