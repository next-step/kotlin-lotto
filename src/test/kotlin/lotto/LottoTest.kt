package lotto

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.collections.shouldHaveSize
import lotto.domain.Lotto
import lotto.domain.LottoNumber

class LottoTest : StringSpec({
    "로또는 6자리 숫자로 이루어져 있다." {
        val lottoNumbers = setOf(
            LottoNumber.from(1),
            LottoNumber.from(2),
            LottoNumber.from(3),
            LottoNumber.from(4),
            LottoNumber.from(5),
            LottoNumber.from(6)
        )

        Lotto(lottoNumbers).lottoNumbers shouldHaveSize 6
    }

    "로또 6자리 수로 이루어지지 않는다면 예외가 발생한다." {
        val lottoNumbers = setOf(LottoNumber.from(1), LottoNumber.from(2))

        shouldThrow<IllegalArgumentException> {
            Lotto(lottoNumbers)
        }
    }
})
