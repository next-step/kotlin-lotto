package lotto.util

import io.kotest.assertions.throwables.shouldThrowExactly
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe
import io.kotest.matchers.throwable.shouldHaveMessage

class KotlinRandomGenerateTest : DescribeSpec({
    it("유니크한 랜덤 숫자 리스트 를 가져옵니다") {
        // given
        val randomRange = 1..100
        val listSize = 10

        // when
        val makeRandomUniqueIntList = KotlinRandomGenerate.makeRandomUniqueIntList(listSize, randomRange)

        // then
        makeRandomUniqueIntList.size shouldBe listSize
    }

    it("가져올 리스트 갯수가 랜덤 숫자 범위 보다 큰 경우 IllegalArgumentException 발생") {
        // given
        val randomRange = 1..4
        val listSize = 10

        // then
        shouldThrowExactly<IllegalArgumentException> {
            KotlinRandomGenerate.makeRandomUniqueIntList(listSize, randomRange)
        }.shouldHaveMessage("랜덤범위(1..4)가 가져올 리스트 갯수(10) 보다 큽니다")
    }
})
