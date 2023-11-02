package lotto.util

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class ShuffleNumberTest : StringSpec({
    "로또 번호를 섞는다." {
        val numbers = shuffleNumber()
        numbers.forEach(
            fun(number: Int) {
                (1..45).contains(number) shouldBe true
            }
        )
    }
})
