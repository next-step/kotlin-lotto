package newlotto.domain

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe
import newlotto.Lotto
import newlotto.Rank

class LottoTest : DescribeSpec({
    it("로또 번호가 1 - 44 까지 범위를 가지지 않으면 오류를 발생시킨다.") {
        val exception = shouldThrow<IllegalArgumentException> { Lotto(listOf<Int>(1, 2, 3, 4, 5, 46)) }

        exception.message shouldBe "로또 번호는 1 ~ 44 까지 범위만 가질 수 있습니다."
    }

    it("로또 번호 중에 중복된 번호가 있다면 오류를 발생시킨다.") {
        val exception = shouldThrow<IllegalArgumentException> { Lotto(listOf<Int>(1, 1, 2, 3, 4, 5)) }

        exception.message shouldBe "로또 번호는 중복될 수 없습니다."
    }

    describe("match") {
        // TOOD 리팩토링 대상
        it("로또 번호와 당첨 번호를 비교해서 일치하는 Rank 를 알려준다.") {
            val lotto = Lotto(listOf(1, 2, 3, 4, 5, 6))

            val expectFistRank = lotto.match(listOf(1, 2, 3, 4, 5, 6))
            val expectSecondRank = lotto.match(listOf(1, 2, 3, 4, 5, 7))
            val expectThirdRank = lotto.match(listOf(1, 2, 3, 4, 7, 8))
            val expectForthRank = lotto.match(listOf(1, 2, 3, 7, 8, 9))
            val expectMissRank = lotto.match(listOf(1, 2, 7, 8, 9, 10))
            val expectMissRank2 = lotto.match(listOf(1, 7, 8, 9, 10, 11))
            val expectMissRank3 = lotto.match(listOf(7, 8, 9, 10, 11, 12))

            expectFistRank shouldBe Rank.FIRST
            expectSecondRank shouldBe Rank.SECOND
            expectThirdRank shouldBe Rank.THIRD
            expectForthRank shouldBe Rank.FOURTH
            expectMissRank shouldBe Rank.MISS
            expectMissRank2 shouldBe Rank.MISS
            expectMissRank3 shouldBe Rank.MISS
        }
    }

})
