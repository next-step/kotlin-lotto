package lotto.model

import io.kotest.assertions.throwables.shouldNotThrowAny
import io.kotest.assertions.throwables.shouldThrowExactly
import io.kotest.core.spec.style.StringSpec
import io.kotest.inspectors.forAll
import io.kotest.matchers.shouldBe

class ManualLottoTicketStorageTest : StringSpec({

    "로또들로 생성" {
        shouldNotThrowAny {
            ManualLottoTicketStorage(listOf(ONE_TO_SIX_LOTTO))
        }
    }

    "1개의 로또 개수 보다 적은 여부" {
        listOf(
            0 to false,
            1 to false,
            2 to true,
            3 to true
        ).forAll {
            (ManualLottoTicketStorage(listOf(ONE_TO_SIX_LOTTO)) hasCountLessThan it.first) shouldBe it.second
        }
    }

    "개수만큼 수동 로또 티켓 반환" {
        // given
        val twoLottoTicketStorage = ManualLottoTicketStorage(listOf(ONE_TO_SIX_LOTTO, ONE_TO_SIX_LOTTO))
        // when & then
        (twoLottoTicketStorage lottoTicketsBy 1) shouldBe listOf(LottoTicket(ONE_TO_SIX_LOTTO, TicketType.MANUAL))
    }

    "보유한 로또 개수보다 많이 요구하면 예외" {
        shouldThrowExactly<IllegalArgumentException> {
            ManualLottoTicketStorage(listOf(ONE_TO_SIX_LOTTO)) lottoTicketsBy Int.MAX_VALUE
        }
    }
})
