package lotto.model

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class LottoNumbersTest : StringSpec({

    "포함하는 6개의 lottoNumber 들은 오름차순으로 정렬되어있어야 한다" {
        val actual = LottoNumbers(listOf(11, 27, 22, 33, 35, 4))
        actual shouldBe LottoNumbers(listOf(4, 11, 22, 27, 33, 35))
    }
})
