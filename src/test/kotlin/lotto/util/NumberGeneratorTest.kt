package lotto.util

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.collections.shouldHaveSize
import io.kotest.matchers.ints.shouldBeInRange

class NumberGeneratorTest : StringSpec({

    val numberGenerator = NumberGenerator()

    "랜덤 숫자 생성 개수 확인 테스트" {
        val start = 1
        val end = 100
        val inputSize = 7
        val randomNumbers = numberGenerator.random(start, end, 7)
        randomNumbers shouldHaveSize inputSize
        randomNumbers.forEach {
            it shouldBeInRange start..end
        }
    }
})
