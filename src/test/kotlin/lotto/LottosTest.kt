package lotto

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

internal class LottosTest : StringSpec({
    "포함하고 있는 모든 로또의 총 합을 구한다" {
        val numbers = LottoNumber.of(listOf(1, 2, 3, 4, 5, 6))
        val sut = Lottos(listOf(Lotto(numbers, 1000), Lotto(numbers, 2000)))
        sut.getTotalPrice() shouldBe 3000
    }
})
