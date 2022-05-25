package lotto.domain

import io.kotest.assertions.throwables.shouldNotThrow
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import lotto.domain.vo.LottoNumber

class LottoBundleTest : StringSpec({
    "로또 번들을 생성할 수 있다" {
        val lottoNumbers = setOf(
            LottoNumber(1),
            LottoNumber(2),
            LottoNumber(3),
            LottoNumber(4),
            LottoNumber(5),
            LottoNumber(6)
        )

        shouldNotThrow<Throwable> { LottoBundle(listOf(Lotto(lottoNumbers))) }
    }

    "로또가 하나도 없을 경우 로또 번들 생성시 Exception을 던진다" {
        shouldThrow<IllegalArgumentException> { LottoBundle(listOf()) }
    }
})
