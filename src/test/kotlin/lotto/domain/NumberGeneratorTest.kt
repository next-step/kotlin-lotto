package lotto.domain

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.collections.shouldHaveSize

class NumberGeneratorTest : StringSpec({

    val numberGenerator = NumberGenerator()

    "랜덤 숫자 생성 개수 확인 테스트" {
        val inputSize = 7
        val randomNumbers = numberGenerator.random(1, 100, 7)
        randomNumbers shouldHaveSize inputSize
    }
})
