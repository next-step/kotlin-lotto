package lotto.model

import io.kotest.core.spec.DisplayName
import io.kotest.core.spec.style.StringSpec
import io.kotest.inspectors.forAll
import io.kotest.matchers.collections.shouldHaveSize
import io.kotest.matchers.shouldBe

@DisplayName("랜덤 로또 티켓 저장소")
class RandomLottoTicketStorageTest : StringSpec({

    "개수는 항상 많음" {
        RandomLottoTicketStorage hasCountLessThan Int.MAX_VALUE shouldBe true
    }

    "개수 만큼 로또 티켓 가져오기" {
        listOf(1, 10, 30).forAll {
            (RandomLottoTicketStorage lottoTicketsBy it) shouldHaveSize it
        }
    }
})
