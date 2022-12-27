package lotto.util

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.collections.shouldHaveSize
import io.kotest.matchers.ints.shouldBeInRange

class RandomNumberGeneratorTest : StringSpec({

    val numberGenerator = RandomNumberGenerator()

    "랜덤 숫자 생성 개수 확인 테스트" {
        // given
        val start = 1
        val end = 100
        val inputSize = 7
        // when
        val randomNumbers = numberGenerator.generate(start, end, 7)
        // then
        randomNumbers shouldHaveSize inputSize
        randomNumbers.forEach {
            it shouldBeInRange start..end
        }
    }
})
