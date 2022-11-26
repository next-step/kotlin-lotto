package lotto.domain

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.BehaviorSpec
import java.lang.IllegalArgumentException

internal class WinningLottoNumbersTest : BehaviorSpec({
    given("당첨 번호를 입력했을 때") {
        `when`("숫자가 아닌 문자가 있다면") {
            val input = "df, d, 1, f, ff, yoon"

            then("IllegalArgumentException 이 발생한다.") {
                shouldThrow<IllegalArgumentException> {
                    WinningLottoNumbers.from(input)
                }
            }
        }
    }
})
