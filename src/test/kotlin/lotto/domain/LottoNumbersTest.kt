package lotto.domain

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class LottoNumbersTest : FunSpec({

    test("로또 숫자끼리 비교가 가능하다.") {
        val numbers1 = LottoNumbers(2, 1, 6, 5, 4, 3)
        val numbers2 = LottoNumbers(3, 4, 5, 6, 7, 8)
        numbers1.matchingNumbers(numbers2) shouldBe listOf(3, 4, 5, 6).map { LottoNumber(it) }
    }

    test("로또번호에 특정 숫자가 포함되어 있는지 확인 가능합니다.") {
        val lottoNumbers = LottoNumbers(1, 2, 3, 4, 5, 6)
        (1 in lottoNumbers) shouldBe true
        (7 in lottoNumbers) shouldBe false

        (LottoNumber(1) in lottoNumbers) shouldBe true
        (LottoNumber(7) in lottoNumbers) shouldBe false
    }
})
