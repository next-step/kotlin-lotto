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
            TestSet(Lotto(setOf(1, 2, 3, 4, 5, 6)), Lotto(setOf(1, 2, 3, 4, 5, 6)), Rank.FIRST),
            TestSet(Lotto(setOf(1, 2, 3, 4, 5, 6)), Lotto(setOf(1, 2, 3, 4, 5, 7)), Rank.SECOND),
            TestSet(Lotto(setOf(1, 2, 3, 4, 5, 6)), Lotto(setOf(1, 2, 3, 4, 7, 8)), Rank.THIRD),
            TestSet(Lotto(setOf(1, 2, 3, 4, 5, 6)), Lotto(setOf(1, 2, 3, 7, 8, 9)), Rank.FOURTH),
            TestSet(Lotto(setOf(1, 2, 3, 4, 5, 6)), Lotto(setOf(1, 2, 7, 8, 9, 10)), Rank.NO_RANK),
            TestSet(Lotto(setOf(1, 2, 3, 4, 5, 6)), Lotto(setOf(1, 7, 8, 9, 10, 11)), Rank.NO_RANK),
            TestSet(Lotto(setOf(1, 2, 3, 4, 5, 6)), Lotto(setOf(7, 8, 9, 10, 11, 12)), Rank.NO_RANK),
        ) { (lotto, otherLotto, result) ->
            lotto.match(otherLotto) shouldBe result
        }
    }
})

data class TestSet(val lotto: Lotto, val otherLotto: Lotto, val result: Rank) : WithDataTestName {
    override fun dataTestName() = "${lotto.numbers}와 ${otherLotto.numbers}를 비교했을 때 랭크는 $result 이다"
}
