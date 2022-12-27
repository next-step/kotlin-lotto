package lotto.domain

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec

internal class WinningBallsTest : StringSpec({
    "로또 당첨 번호가 중복되면 예외가 발생한다." {
        shouldThrow<IllegalArgumentException> {
            WinningBalls(
                setOf(
                    LottoNumber(1), LottoNumber(5), LottoNumber(3),
                    LottoNumber(4), LottoNumber(5), LottoNumber(6)
                )
            )
        }
    }
})
