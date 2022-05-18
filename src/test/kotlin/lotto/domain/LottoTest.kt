package lotto.domain

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class LottoTest : FunSpec({

    test("Lotto 숫자는 6개로 구성된다.") {
        val lotto = Lotto(listOf(1,2,3,4,5,6))
        lotto.numbers.size shouldBe 6
    }
})
