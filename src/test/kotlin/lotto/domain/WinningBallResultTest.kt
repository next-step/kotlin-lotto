package lotto.domain

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec

internal class WinningBallResultTest : StringSpec({
    "로또 볼과 보너스 볼이 중복되면 예외가 발생한다." {
        shouldThrow<IllegalArgumentException> {
            WinningBallResult(
                WinningBalls(
                    setOf(
                        LottoNumber(1), LottoNumber(2), LottoNumber(3),
                        LottoNumber(4), LottoNumber(5), LottoNumber(6)
                    )
                ),
                LottoNumber(1)
            )
        }
    }
})
