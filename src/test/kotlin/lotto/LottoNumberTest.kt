package lotto

import io.kotest.core.spec.style.FreeSpec
import io.kotest.matchers.shouldBe

class LottoNumberTest : FreeSpec({

    "value class 테스트" - {
        "동일한 번호로 LottoNumber 생성 시 동일한 인스턴스다" {
            val lottoNumber1 = LottoNumber(1)
            val lottoNumber2 = LottoNumber(1)

            lottoNumber1 shouldBe lottoNumber2
            (lottoNumber1 == lottoNumber2) shouldBe true
        }
    }
})
