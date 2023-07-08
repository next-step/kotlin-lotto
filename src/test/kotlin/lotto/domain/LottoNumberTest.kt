package lotto.domain

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class LottoNumberTest : FunSpec({
    context("로또 번호는 1~45 범위를 갖습니다.") {
        LottoNumber(1).number shouldBe 1
        LottoNumber(45).number shouldBe 45
    }
})
