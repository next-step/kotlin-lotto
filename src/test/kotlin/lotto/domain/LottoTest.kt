package lotto.domain

import io.kotest.assertions.throwables.shouldNotThrow
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import lotto.domain.vo.LottoNumber

class LottoTest : StringSpec({
    "로또객체를 생성할 수 있다." {
        val lottoNumbers = setOf(
            LottoNumber(1),
            LottoNumber(2),
            LottoNumber(3),
            LottoNumber(4),
            LottoNumber(5),
            LottoNumber(6)
        )

        shouldNotThrow<Throwable> { Lotto(lottoNumbers) }
    }

    "로또 숫자가 6개가 아닌 경우 Exception을 던진다" {
        val lottoNumbers = setOf(
            LottoNumber(1),
            LottoNumber(2),
            LottoNumber(3),
            LottoNumber(4),
            LottoNumber(5)
        )

        shouldThrow<IllegalArgumentException> { Lotto(lottoNumbers) }
    }

    "로또 숫자가 중복되는 경우 Exception을 던진다" {
        val lottoNumbers = setOf(
            LottoNumber(1),
            LottoNumber(2),
            LottoNumber(4),
            LottoNumber(4),
            LottoNumber(5),
            LottoNumber(5)
        )

        shouldThrow<IllegalArgumentException> { Lotto(lottoNumbers) }
    }
})
