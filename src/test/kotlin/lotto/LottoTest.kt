package lotto

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.FreeSpec
import io.kotest.matchers.shouldBe
import lotto.domain.Lotto
import lotto.util.lottoNumberSetOf
import java.lang.IllegalArgumentException

class LottoTest : FreeSpec({
    "로또는" - {
        "6개의 중복되지 않는 LottoNumber를 가진다" {
            val numbers = lottoNumberSetOf(1, 2, 3, 4, 5, 6)
            val lotto = Lotto(numbers)
            lotto.count() shouldBe 6
        }
        "LottoNumber가 중복되면 예외가 발생한다." {
            val numbers = lottoNumberSetOf(1, 2, 3, 4, 5, 5)
            shouldThrow<IllegalArgumentException> {
                Lotto(numbers)
            }
        }
        "LottoNumber가 6개 미만이면 예외가 발생한다." {
            val numbers = lottoNumberSetOf(1, 2, 3, 4, 5)
            shouldThrow<IllegalArgumentException> {
                Lotto(numbers)
            }
        }
        "LottoNumber가 6개 초과이면 예외가 발생한다." {
            val numbers = lottoNumberSetOf(1, 2, 3, 4, 5, 6, 7)
            shouldThrow<IllegalArgumentException> {
                Lotto(numbers)
            }
        }
    }
})
