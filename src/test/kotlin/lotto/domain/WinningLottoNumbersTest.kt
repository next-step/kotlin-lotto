package lotto.domain

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.BehaviorSpec

internal class WinningLottoNumbersTest : BehaviorSpec({
    given("입력된 보너스 볼의 숫자가") {
        val bonusBall = LottoNumber(3)

        `when`("당첨 번호와 중복될 때") {
            val winningLottoNumbers = LottoNumbers(
                listOf(
                    LottoNumber(3),
                    LottoNumber(4),
                    LottoNumber(5),
                    LottoNumber(6),
                    LottoNumber(7),
                    LottoNumber(8),
                )
            )
            then("IllegalArgumentException 이 발생한다.") {
                shouldThrow<IllegalArgumentException> {
                    WinningLottoNumbers(lottoNumbers = winningLottoNumbers, bonusLottoNumbers = bonusBall)
                }
            }
        }
    }
})
