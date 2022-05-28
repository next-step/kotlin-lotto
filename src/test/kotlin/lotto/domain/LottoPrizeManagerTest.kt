package lotto.domain

import io.kotest.assertions.throwables.shouldThrowExactly
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe
import io.kotest.matchers.throwable.shouldHaveMessage

class LottoPrizeManagerTest : DescribeSpec({

    it("담청 정책을 추가 할 수 있다") {
        // given
        val lottoPrizeManager = LottoPrizeManager()
        val addPrizePolicy = LottoPrizePolicy(3, Money(10000))

        // when
        lottoPrizeManager.addUniquePolicy(addPrizePolicy)

        // then
        lottoPrizeManager.getItem(0).wonMatchedCount shouldBe addPrizePolicy.wonMatchedCount
    }

    describe("validate") {
        it("중복된 당첨 정책을 추가한 경우 에러 발생") {
            // given
            val lottoPrizeManager = LottoPrizeManager()
            val addPrizePolicy = LottoPrizePolicy(3, Money(10000))
            val duplicatedPolicy = LottoPrizePolicy(3, Money(10000))

            // then
            shouldThrowExactly<IllegalArgumentException> {
                lottoPrizeManager.addUniquePolicy(addPrizePolicy)
                lottoPrizeManager.addUniquePolicy(duplicatedPolicy)
            }.shouldHaveMessage("동일한 당첨 정책이 존재합니다")
        }
    }
})
