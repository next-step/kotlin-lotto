package lotto.domain

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class LottoNumbersTest : FunSpec({
    context("로또 번호는 1~45 범위를 갖습니다.") {
        LottoNumbers(setOf(1, 2, 3, 4, 5, 6)).numbers.forEach {
            // it이 1~45 범위인지 확인
            (it in 1..45) shouldBe true
        }
    }
})
