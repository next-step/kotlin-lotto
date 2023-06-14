package lotto.model

import io.kotest.assertions.throwables.shouldNotThrowAny
import io.kotest.core.spec.DisplayName
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.types.shouldBeInstanceOf

@DisplayName("랜덤 로또 티켓 저장소")
class RandomLottoTicketStorageTest : StringSpec({

    "로또 티켓 가져오기" {
        // given & when
        val lottoTicket: LottoTicket = RandomLottoTicketStorage.lottoTicket
        // then
        shouldNotThrowAny {
            lottoTicket.shouldBeInstanceOf<LottoTicket>()
        }
    }
})
