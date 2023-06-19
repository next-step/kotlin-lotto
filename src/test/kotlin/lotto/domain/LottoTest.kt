package lotto.domain

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class LottoTest: StringSpec({
    "로또에 로또 번호가 포함 되어 있다." {
        val lottoNumber = LottoNumber(1)
        val lotto = Lotto(listOf(lottoNumber))
        lotto.contains(LottoNumber(1)) shouldBe true
    }

    "로또에 로또 번호가 포함 되어 있지 않다." {
        val lottoNumber = LottoNumber(2)
        val lotto = Lotto(listOf(lottoNumber))
        lotto.contains(LottoNumber(1)) shouldBe false
    }
})
