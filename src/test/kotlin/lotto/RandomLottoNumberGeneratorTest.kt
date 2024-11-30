package lotto

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.collections.shouldHaveSize
import io.kotest.matchers.shouldBe
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class RandomLottoNumberGeneratorTest : StringSpec({
    "6개의 숫자 목록을 생성한다" {
        val numbers = RandomLottoNumberGenerator.generate()
        numbers shouldHaveSize 6
    }
})
