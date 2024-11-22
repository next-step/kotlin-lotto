package lotto

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class LottoFactoryTest : StringSpec({
    val numberGenerator = RandomNumberGenerator()
    val sut = LottoFactory(numberGenerator)

    "6개의 숫자가 있는 로또를 입력받은 수만큼 생성한다" {
        val quantity = 14

        val actual = sut.create(quantity)

        actual.size shouldBe 14
    }
})
