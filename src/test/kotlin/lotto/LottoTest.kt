package lotto

import io.kotest.core.spec.style.FunSpec
import io.kotest.datatest.WithDataTestName
import io.kotest.datatest.withData
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Assertions.assertThrows

class LottoTest : FunSpec({

    context("로또 번호는 6개만 가능합니다.") {
        val exception = assertThrows(IllegalArgumentException::class.java) {
            Lotto(setOf(1, 2, 3, 4, 5))
        }
        exception.message shouldBe "로또 번호는 6개만 가능합니다."
    }

    context("로또 숫자 비교") {
        withData(
            TestSet(Lotto(setOf(1, 2, 3, 4, 5, 6)), Lotto(setOf(1, 2, 3, 4, 5, 6)), 6),
            TestSet(Lotto(setOf(1, 2, 3, 4, 5, 6)), Lotto(setOf(1, 2, 3, 4, 5, 7)), 5),
            TestSet(Lotto(setOf(1, 2, 3, 4, 5, 6)), Lotto(setOf(1, 2, 3, 4, 7, 8)), 4),
            TestSet(Lotto(setOf(1, 2, 3, 4, 5, 6)), Lotto(setOf(1, 2, 3, 7, 8, 9)), 3),
            TestSet(Lotto(setOf(1, 2, 3, 4, 5, 6)), Lotto(setOf(1, 2, 7, 8, 9, 10)), 2),
            TestSet(Lotto(setOf(1, 2, 3, 4, 5, 6)), Lotto(setOf(1, 7, 8, 9, 10, 11)), 1),
            TestSet(Lotto(setOf(1, 2, 3, 4, 5, 6)), Lotto(setOf(7, 8, 9, 10, 11, 12)), 0),
        ) { (lotto, otherLotto, result) ->
            lotto.match(otherLotto) shouldBe result
        }
    }
})

data class TestSet(val lotto: Lotto, val otherLotto: Lotto, val result: Int) : WithDataTestName {
    override fun dataTestName() = "${lotto.numbers}와 ${otherLotto.numbers}를 비교했을 때 $result 개가 일치한다."
}
