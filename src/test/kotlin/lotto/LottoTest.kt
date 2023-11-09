package lotto

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe
import io.kotest.matchers.types.shouldBeInstanceOf

class LottoTest : FunSpec({
    test("로또 한 장은 숫자 6개를 가진다.") {
        val lotto = Lotto(listOf(10, 20, 10, 45, 15, 6))
        lotto.numbers.size shouldBe 6
        lotto.numbers.shouldBeInstanceOf<List<Int>>()
    }
})
