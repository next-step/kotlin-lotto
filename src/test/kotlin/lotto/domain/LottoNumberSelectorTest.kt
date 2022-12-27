package lotto.domain

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

internal class LottoNumberSelectorTest : StringSpec({
    "로또 번호를 6개 선택할 수 있다." {
        LottoNumberSelector.select().size shouldBe 6
    }
})
