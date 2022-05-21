package lotto.domain

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class LottoNumbersTest : FunSpec({

    test("로또 숫자끼리 비교가 가능하다.") {
        val numbers1 = LottoNumbers(listOf(2, 1, 6, 5, 4, 3))
        val numbers2 = LottoNumbers(listOf(3, 4, 5, 6, 7, 8))
        numbers1.matchingNumbers(numbers2) shouldBe listOf(3, 4, 5, 6)
    }
})
