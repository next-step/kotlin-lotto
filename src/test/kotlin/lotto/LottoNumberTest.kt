package lotto

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class LottoNumberTest: StringSpec({
    "로또 번호는 6개의 숫자를 가지고 있다" {
        val lottoNumber = LottoNumber()
        lottoNumber.numbers.size shouldBe 6
    }
})
