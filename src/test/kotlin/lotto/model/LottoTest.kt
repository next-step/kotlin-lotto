package lotto.model

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class LottoTest : StringSpec({

    "로또 객채는 당첨번호와 비교해서 당첨등급을 평가할 수 있다" {
        // given
        val lotto = Lotto(LottoNumbers(StaticLottoNumberGenerator(listOf(1, 2, 3, 4, 5, 6)).pick()))
        val winningNumber: List<LottoNumber> = listOf(
            LottoNumber(1),
            LottoNumber(2),
            LottoNumber(3),
            LottoNumber(4),
            LottoNumber(5),
            LottoNumber(6)
        )
        // when
        val grade = lotto.scratch(LottoNumbers(winningNumber))
        // then
        grade shouldBe LottoGrade.FIST_GRADE
    }
})
