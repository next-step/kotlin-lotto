package lotto.domain

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec

class WinningNumberTest : StringSpec({

    "당첨 번호에 보너스 번호가 있으면 예외가 발생한다." {
        val lotto = Lotto(
            listOf(
                LottoNumber(1),
                LottoNumber(2),
                LottoNumber(3),
                LottoNumber(4),
                LottoNumber(5),
                LottoNumber(6)
            )
        )
        val bonusNumber = LottoNumber(3)

        shouldThrow<IllegalArgumentException> {
            WinningNumber(lotto, bonusNumber)
        }
    }
})
