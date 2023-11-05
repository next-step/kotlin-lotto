package lotto_auto

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe
import lotto_auto.lotto.Lotto

class LottoTest : FunSpec({
    val lotto = Lotto()
    test("자동으로 생성된 번호는 6개이다") {
        val expected = 6

        lotto.number.count() shouldBe expected
    }

    test("생성된 번호는 겹치지 않는다") {
        val lottoSet = lotto.number.toSet()

        lotto.number.count() shouldBe lottoSet.count()
    }

    test("로또 생성시에 번호를 전달하면, 전달된 대로 생성한다") {
        val winningLotto = Lotto(listOf(1, 2, 3, 4, 5, 6))
        val expected = listOf(1, 2, 3, 4, 5, 6)
        winningLotto.number shouldBe expected
    }
})
