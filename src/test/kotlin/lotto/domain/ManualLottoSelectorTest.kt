package lotto.domain

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class ManualLottoSelectorTest : StringSpec({
    "입력한 번호로 로또를 생성한다" {
        ManualLottoSelector(listOf(1, 2, 3, 4, 5, 6)).select() shouldBe Lotto(1, 2, 3, 4, 5, 6)
    }
})
