package lotto.domain

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.BehaviorSpec
import java.lang.IllegalArgumentException

class LottoWinningNumberTest : BehaviorSpec({

    Given("로또 당첨 번호가 , 기준으로 6개가 아니거나 문자가 들어온다면") {
        Then("예외를 반환한다.") {
            shouldThrow<IllegalArgumentException> {
                LottoWinningNumber.of("1, 2, 3, 4, 5", "6")
            }

            shouldThrow<IllegalArgumentException> {
                LottoWinningNumber.of("1, 2, 3, 4, a", "6")
            }
        }
    }
})
