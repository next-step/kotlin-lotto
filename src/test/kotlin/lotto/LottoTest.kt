package lotto

import calculator.StringAdditionCalculator
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class Lotto(private val money: Int) {
    init {
        require(money % LOTTO_PRICE_UNIT == 0) { LOTTO_PRICE_UNIT_EXCEPTION_MESSAGE }
    }

    fun buyCount(): Int {
        return money / LOTTO_PRICE_UNIT
    }

    companion object {
        private const val LOTTO_PRICE_UNIT = 1000
        private const val LOTTO_PRICE_UNIT_EXCEPTION_MESSAGE = "구매금액은 1000원 단위로만 가능합니다."
    }
}

class LottoTest : StringSpec({
    "구매금액을 입력하면 몇 개를 구매했는지 반환해야 한다." {
        Lotto(14000).buyCount() shouldBe 14
        Lotto(25000).buyCount() shouldBe 25
    }

    "구매금액은 1000원 단위로만 가능하다." {
        val exception =
            shouldThrow<IllegalArgumentException> {
                Lotto(1400)
            }
        exception.message shouldBe "구매금액은 1000원 단위로만 가능합니다."
    }
})