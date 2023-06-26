package lotto.domain

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class LottoNumbersTest : StringSpec({
    "로또의 번호는 정렬 되어야 한다." {
        val lottoNumbers = LottoNumbers(
            setOf(
                LottoNumber.from(6), LottoNumber.from(5),
                LottoNumber.from(4), LottoNumber.from(3),
                LottoNumber.from(2), LottoNumber.from(1)
            )
        )

        lottoNumbers.lottoNumbers.first().value shouldBe 1
        lottoNumbers.lottoNumbers.last().value shouldBe 6
    }
})
