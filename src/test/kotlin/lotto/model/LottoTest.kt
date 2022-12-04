package lotto.model

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class LottoTest : StringSpec({

    "로또 객채는 당첨번호와 비교해서 당첨등급을 평가할 수 있다" {
        // given
        val lotto = StaticLottoNumberGenerator(listOf(1, 2, 3, 4, 5, 6)).pick()
        val winningNumber: List<LottoNumber> = listOf(
            LottoNumber.valueOf(1),
            LottoNumber.valueOf(2),
            LottoNumber.valueOf(3),
            LottoNumber.valueOf(4),
            LottoNumber.valueOf(5),
            LottoNumber.valueOf(6)
        )
        // when
        val grade = lotto.scratch(LottoNumbers(winningNumber), LottoNumber.valueOf(10))
        // then
        grade shouldBe LottoGrade.FIST_GRADE
    }
})
