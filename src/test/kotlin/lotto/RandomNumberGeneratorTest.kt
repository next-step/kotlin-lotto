package lotto

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class RandomNumberGeneratorTest : FunSpec({
    test("랜덤 숫자 생성기에 숫자A, 숫자B, N을 전달하면 숫자A ~ 숫자B 숫자를 N개 반환한다.") {
        val randomNumberGenerator = RandomNumberGenerator()
        val numbers = randomNumberGenerator.generateNumber(1, 45, 6)
        numbers.size shouldBe 6
    }

    test("랜덤 숫자 생성기의 전달될 숫자A가 숫자B보다 크면 예외가 발생한다.") {
        val randomNumberGenerator = RandomNumberGenerator()
        shouldThrow<IllegalArgumentException> { randomNumberGenerator.generateNumber(10, 1, 6) }
    }

    test("랜덤 숫자 생성기의 전달될 숫자A~숫자B 사이의 개수보다 N이 크면 예외가 발생한다.") {
        val randomNumberGenerator = RandomNumberGenerator()
        shouldThrow<IllegalArgumentException> { randomNumberGenerator.generateNumber(1, 10, 11) }
    }
})
