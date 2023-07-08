package lotto.domain

import io.kotest.assertions.throwables.shouldNotThrowAny
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.FunSpec
import io.kotest.datatest.withData
import io.kotest.matchers.shouldBe

class LottoNumberTest : FunSpec({
    context("로또 번호는 1~45 범위를 갑습니다. 1~45 이내의 숫자이면 오류가 발생하지 않습니다.") {
        // given
        val input = 1

        // when // then
        shouldNotThrowAny { LottoNumber.from(input) }
    }

    context("로또 번호는 1~45 범위를 갖습니다. 범위를 벗어나면 오류가 발생합니다.") {
        withData(
            0 to "로또 번호는 1부터 45 사이여야 합니다.",
            46 to "로또 번호는 1부터 45 사이여야 합니다.",
        ) { (input, expected) ->
            shouldThrow<IllegalArgumentException> {
                LottoNumber.from(input)
            }.message shouldBe expected
        }
    }
})
