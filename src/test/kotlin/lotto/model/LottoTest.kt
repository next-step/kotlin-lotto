package lotto.model

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class LottoTest : StringSpec({

    "로또 객채는 당첨번호와 비교해서 당첨등급을 평가할 수 있다" {
        // given
        val lotto = Lotto(LottoNumber(StaticLottoNumberGenerator(listOf(1, 2, 3, 4, 5, 6)).pick()))
        val winningNumber: List<Int> = listOf(1, 2, 3, 4, 5, 6)
        // when
        val grade = lotto.scratch(LottoNumber(winningNumber))
        // then
        grade shouldBe LottoGrade.FIST_GRADE
    }
})
