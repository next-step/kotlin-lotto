package lotto

import io.kotest.assertions.throwables.shouldNotThrowAny
import io.kotest.core.spec.DisplayName
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import io.mockk.every
import io.mockk.mockk
import kotlin.random.Random

@DisplayName("랜덤 로또 티켓 저장소")
class RandomLottoTicketStorageTest : StringSpec({

    "랜덤으로 티켓 저장소 생성" {
        shouldNotThrowAny {
            RandomLottoTicketStorage(Random.Default)
        }
    }

    "기본 인자로 저장소 생성" {
        shouldNotThrowAny {
            RandomLottoTicketStorage()
        }
    }

    "랜덤 숫자로 티켓 생성" {
        // given
        val random: Random = mockk<Random>()
        every { random.nextInt(any()) } returns 0
        // when
        val lottoTicket: LottoTicket = RandomLottoTicketStorage(random).lottoTicket
        // then
        lottoTicket shouldBe LottoTicket((LottoNumber(2)..LottoNumber(7)).toSet())
    }
})
