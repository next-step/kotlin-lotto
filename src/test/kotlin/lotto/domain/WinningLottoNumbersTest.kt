package lotto.domain

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.BehaviorSpec

internal class WinningLottoNumbersTest : BehaviorSpec({
    given("입력된 보너스 볼의 숫자가") {
        val bonusBall = LottoNumber(3)

        `when`("당첨 번호와 중복될 때") {
            val winningLottoNumbersNumbers = lottoNumberOf(3, 4, 5, 6, 7, 8)

            then("IllegalArgumentException 이 발생한다.") {
                shouldThrow<IllegalArgumentException> {
                    WinningLottoNumbers(lottoNumbers = winningLottoNumbersNumbers, bonusLottoNumber = bonusBall)
                }
            }
        }
    }
})
