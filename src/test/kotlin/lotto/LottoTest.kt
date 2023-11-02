package lotto

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.ints.shouldBeInRange
import io.kotest.matchers.shouldBe

class LottoTest : FunSpec({

    test("로또 1장의 가격은 1000원이다.") {
        val lotto = Lotto()
        lotto.price shouldBe 1000
    }

    test("로또 1장은 6개의 숫자를 가진다.") {
        val lotto = Lotto()
        lotto.numbers.size shouldBe 6
    }

    test("로또 1장의 숫자는 1부터 45까지의 숫자이다.") {
        val lotto = Lotto()
        lotto.numbers.forEach {
            it shouldBeInRange 1..45
        }
    }

    test("로또 1장의 숫자는 중복되지 않는다.") {
        val lotto = Lotto()
        lotto.numbers.toSet().size shouldBe 6
    }
})
