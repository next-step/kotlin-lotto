package lotto.domain

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class LottosTest : StringSpec({
    "자동 1개, 수동 1개 구매 시 로또 2개 구매 확인" {
        val lottos = Lottos(listOf(Lotto.from("1,2,3,4,5,6"), Lotto.from("1,2,3,4,5,6")))
        lottos.lottos.size shouldBe 2
    }
})
