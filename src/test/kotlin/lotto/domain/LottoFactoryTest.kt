package lotto.domain

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class LottoFactoryTest : StringSpec({
    val numberGenerator = RandomNumberGenerator()
    val sut = LottoFactory(numberGenerator)

    "6개의 숫자가 있는 로또를 입력받은 수만큼 자동으로 생성한다" {
        val quantity = 14

        val actual = sut.createAuto(quantity)

        actual.size shouldBe 14
    }

    "입력받은 숫자로 로또를 생성한다" {
        val numbers = listOf(listOf(1, 2, 3, 4, 5, 6), listOf(7, 8, 9, 10, 11, 12))

        val actual = sut.createManual(numbers)

        actual.size shouldBe 2
    }
})
