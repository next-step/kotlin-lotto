package lotto.step4

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe
import lotto.step4.domain.Lotto
import lotto.step4.domain.LottoNumber

class LottoTest : FunSpec({
    test("로또를 처음 생성하면 numbers의 개수는 6이다.") {
        // given
        val givenNumbers =
            listOf(
                LottoNumber(1),
                LottoNumber(2),
                LottoNumber(3),
                LottoNumber(4),
                LottoNumber(5),
                LottoNumber(6),
            )

        // when
        val result = Lotto.of(givenNumbers)

        // then
        result.numbers.size shouldBe 6
    }

    test("로또를 생성할 때 중복된 번호가 있으면 IllegalArgumentException이 발생한다.") {
        // given
        val givenNumbers =
            listOf(
                LottoNumber(1),
                LottoNumber(2),
                LottoNumber(3),
                LottoNumber(4),
                LottoNumber(5),
                LottoNumber(5),
            )

        // when & then
        shouldThrow<IllegalArgumentException> {
            Lotto.of(givenNumbers)
        }
    }
})
