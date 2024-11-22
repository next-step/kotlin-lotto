package lotto

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class NumberGeneratorTest : StringSpec({
    "숫자 생성기는 1 ~ 45 범위의 숫자 6개를 반환한다" {
        val numberGenerator = RandomNumberGenerator()
        val numbers = numberGenerator.generate()

        numbers.size shouldBe 6
        numbers.filter { it.value < 1 || it.value > 45 }.size shouldBe 0
    }
})
