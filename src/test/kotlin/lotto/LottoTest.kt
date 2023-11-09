package lotto

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe
import io.kotest.matchers.types.shouldBeInstanceOf

class LottoTest : FunSpec({
    test("로또 한 장은 숫자 6개를 가진다.") {
        val lotto = Lotto(listOf(10, 20, 10, 45, 15, 6))
        lotto.numbers.size shouldBe 6
        lotto.numbers.shouldBeInstanceOf<List<Int>>()
    }

    test("로또에 적힌 숫자 개수가 6개를 넘는다면 예외가 발생한다.") {
        shouldThrow<IllegalArgumentException> { Lotto(listOf(10, 15, 20, 25, 30, 35, 40)) }
    }
})
