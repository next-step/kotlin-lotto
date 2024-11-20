package lotto

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class Lotto(private val money: Int) {
    fun buyCount(): Int {
        return money / 1000
    }
}

class LottoTest : StringSpec({
    "구매금액을 입력하면 몇 개를 구매했는지 반환해야 한다." {
        Lotto(14000).buyCount() shouldBe 14
        Lotto(25000).buyCount() shouldBe 25
    }
})