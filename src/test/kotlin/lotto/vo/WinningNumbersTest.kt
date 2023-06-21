package lotto.vo

import io.kotest.assertions.throwables.shouldThrowWithMessage
import io.kotest.core.spec.style.FreeSpec
import lotto.test.lottoNumbersOf

class WinningNumbersTest : FreeSpec({
    "당첨 번호와 보너스 볼은 중복되면 안 된다." {
        val numbers = lottoNumbersOf(1, 2, 3, 4, 5, 6)
        val bonusNumber = LottoNumber.from(6)

        shouldThrowWithMessage<IllegalArgumentException>("보너스 볼은 당첨 번호와 다른 번호여야 합니다.") {
            WinningNumbers(numbers, bonusNumber)
        }
    }
})
