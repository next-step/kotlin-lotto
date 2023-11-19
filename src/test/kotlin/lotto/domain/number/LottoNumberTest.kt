package lotto.domain.number

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class LottoNumberTest : StringSpec({

    "로또 번호는 1~45 사이의 값이 아니면 실패를 반환한다." {
        listOf(0, 46).forEach { number ->
            val result = LottoNumber.createResult(number)
            result shouldBe LottoNumberResult.Failure("로또 번호는 1부터 45 사이 값이어야 합니다.")
        }
    }
})
