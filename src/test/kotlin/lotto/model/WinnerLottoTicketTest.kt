package lotto.model

import io.kotest.assertions.throwables.shouldNotThrowAny
import io.kotest.assertions.throwables.shouldThrowExactly
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class WinnerLottoTicketTest : StringSpec({

    "로또 티켓과 보너스 볼로 생성" {
        shouldNotThrowAny {
            WinnerLottoTicket(ONE_TO_SIX_LOTTO, LottoNumber(7))
        }
    }

    "로또 티켓에는 보너스 볼을 포함할 수 없음" {
        shouldThrowExactly<IllegalArgumentException> {
            WinnerLottoTicket(ONE_TO_SIX_LOTTO, LottoNumber(1))
        }
    }

    "로또 티켓 조회" {
        // given
        val winnerLottoTicket = WinnerLottoTicket(ONE_TO_SIX_LOTTO, LottoNumber(7))
        // when & then
        winnerLottoTicket.lotto shouldBe ONE_TO_SIX_LOTTO
    }

    "보너스 볼 조회" {
        // given
        val winnerLottoTicket = WinnerLottoTicket(ONE_TO_SIX_LOTTO, LottoNumber(7))
        // when & then
        winnerLottoTicket.bonusNumber shouldBe LottoNumber(7)
    }
})
