package lotto.domain

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.BehaviorSpec
import java.lang.IllegalArgumentException

internal class LottoNumbersTest: BehaviorSpec({
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
})