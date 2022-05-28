package lotto.util

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

class KotlinRandomGenerateTest : DescribeSpec({
    it("ListSize 와 동일한 갯수를 내보낸다") {
        // given
        val randomRange = 1..100
        val listSize = 10

        // when
        val makeRandomUniqueIntList = KotlinRandomGenerate.makeRandomUniqueIntList(listSize, randomRange)

        // then
        makeRandomUniqueIntList.size shouldBe listSize
    }

    it("List Size 가 Range 보다 클 경우 Range 사이즈 만큼에 List 를 내보낸다") {
        // given
        val randomRange = 1..4
        val listSize = 10

        // when
        val makeRandomUniqueIntList = KotlinRandomGenerate.makeRandomUniqueIntList(listSize, randomRange)

        // then
        makeRandomUniqueIntList.size shouldBe randomRange.last
    }
})
