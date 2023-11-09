package lotto

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class RandomNumberGeneratorTest : FunSpec({
    test("랜덤 숫자 생성기에 숫자A, 숫자B, N을 전달하면 숫자A ~ 숫자B 숫자를 N개 반환한다.") {
        val randomNumberGenerator = RandomNumberGenerator()
        val numbers = randomNumberGenerator.generateNumber(1, 45, 6)
        numbers.size shouldBe 6
    }
})
