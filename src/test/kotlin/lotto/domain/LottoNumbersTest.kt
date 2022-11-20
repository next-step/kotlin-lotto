package lotto.domain

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.collections.shouldHaveSize
import io.kotest.matchers.shouldBe

class LottoNumbersTest : StringSpec({
    "중복되지 않는 6개의 숫자를 리스트로 반환한다" {
        val numbers = LottoNumbers.getNumbers()

        numbers shouldHaveSize 6
        numbers shouldBe numbers.distinct()
    }
})
