package lotto.domain

import io.kotest.assertions.throwables.shouldNotThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.collections.shouldContain
import lotto.domain.vo.LottoNumber

class WinningLottoTest : StringSpec({
    "당첨 로또를 생성할 수 있다" {
        shouldNotThrow<Throwable> { WinningLotto(listOf(1, 2, 3, 4, 5, 6)) }
    }

    "당첨 결과를 제공할수 있다" {
        val winningLotto = WinningLotto(listOf(1, 2, 3, 4, 5, 6))

        val lottoNumbers = setOf(
            LottoNumber(1),
            LottoNumber(2),
            LottoNumber(3),
            LottoNumber(4),
            LottoNumber(5),
            LottoNumber(6)
        )

        val lottoBundle = LottoBundle(listOf(Lotto(lottoNumbers)))

        winningLotto.match(lottoBundle) shouldContain WinningResult.SIX_MATCH
    }
})
