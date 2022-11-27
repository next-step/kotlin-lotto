package lotto.domain

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe
import java.lang.IllegalArgumentException

internal class LottoNumbersTest : BehaviorSpec({
    given("입력 받은 숫자가") {
        `when`("로또 번호가 될 수 없는 수라면 (1~45 사이의 값이 아닐 때)") {
            val number = 46

            then("IllegalArgumentException 이 발생한다.") {
                shouldThrow<IllegalArgumentException> {
                    LottoNumbers.convertToLottoNumber(number)
                }
            }
        }
    }

    given("로또를 자동으로 구매했을 때") {
        `when`("랜덤으로 로또 번호를 생성한다면") {
            val result = LottoNumbers.makeRandomLottoNumbers()

            then("중복없는 6자리의 로또 번호가 생성된다.") {
                result.size shouldBe 6
            }
        }
    }
})
