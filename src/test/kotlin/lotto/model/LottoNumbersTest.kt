package lotto.model

import io.kotest.assertions.throwables.shouldNotThrow
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class LottoNumbersTest : StringSpec({

    "6개의 숫자만을 가져야한다" {
        shouldNotThrow<IllegalArgumentException> {
            LottoNumbers(11, 22, 33, 4, 5, 6)
        }
    }

    "6개보다 부족하거나, 초과하면 IllegalArgumentException throw" {
        shouldThrow<IllegalArgumentException> {
            LottoNumbers(11, 22, 33, 4, 5)
        }
        shouldThrow<IllegalArgumentException> {
            LottoNumbers(11, 22, 33, 4, 5, 6, 7)
        }
    }

    "포함하는 6개의 lottoNumber 들은 오름차순으로 정렬되어있어야 한다" {
        val actual = LottoNumbers(listOf(11, 27, 22, 33, 35, 4))
        actual shouldBe LottoNumbers(listOf(4, 11, 22, 27, 33, 35))
    }
})
