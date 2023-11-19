package lotto.domain

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe

class LottoTicketSpec : BehaviorSpec({

    given("숫자가 3개가 일치하는 LottoTicket 이 주어질 때") {
        `when`("같은 숫자의 갯수를 구하면") {
            val lottoNumber = LottoNumber.of(listOf(1, 2, 3, 4, 5, 6))
            val lottoNumber2 = LottoNumber.of(listOf(1, 2, 3, 11, 12, 13))

            then("3이 반환 된다.") {
                lottoNumber countSameNumberWith lottoNumber2 shouldBe 3
            }
        }
    }

    given("보너스 숫자가 일치하는 LottoTicket 이 주어질 때") {
        `when`("보너스 숫자가 일치하는지 확인하면") {
            val lottoNumber = LottoNumber.of(listOf(1, 2, 3, 4, 5, 6))
            val bonusNumber = 6

            then("true 가 반환 된다.") {
                lottoNumber contains bonusNumber shouldBe true
            }
        }
    }
})
