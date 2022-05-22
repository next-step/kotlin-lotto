package lotto

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

internal class LottoTest : StringSpec({

    "숫자 리스트를 받아 Lotto 인스턴스를 생성한다" {
        val lotto = Lotto.of(listOf(1, 2, 3, 4, 5, 6))

        lotto.numbers shouldBe listOf(1, 2, 3, 4, 5, 6)
    }
})
