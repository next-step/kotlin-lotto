package lotto.model

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class LottoTest : StringSpec({

    "로또객채를 생성하면, 번호 생성기를 통해 숫자 6개를 같는다" {
        // given
        val lotto = Lotto()
        // when
        val number = lotto.number
        // then
        number.size shouldBe 6
    }

    "로또 객채는 당첨번호와 비교해서 당첨등급을 평가할 수 있다" {
        // given
        val lotto = Lotto(StaticLottoNumberGenerator(listOf(1, 2, 3, 4, 5, 6)))
        val winningNumber: List<Int> = listOf(1, 2, 3, 4, 5, 6)
        // when
        lotto.scratch(winningNumber)
        // then
        lotto.grade shouldBe LottoGrade.FIST_GRADE
    }
})
