package lotto.model

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import io.kotest.matchers.throwable.shouldHaveMessage

class LottoTest : StringSpec({

    "로또객채를 생성하면, 번호 생성기를 통해 숫자 6개를 같는다" {
        // given
        val lotto = Lotto(RandomLottoNumberGenerator().pick())
        // when
        val number = lotto.number
        // then
        number.size shouldBe 6
    }

    "로또 객채는 당첨번호와 비교해서 당첨등급을 평가할 수 있다" {
        // given
        val lotto = Lotto(StaticLottoNumberGenerator(listOf(1, 2, 3, 4, 5, 6)).pick())
        val winningNumber: List<Int> = listOf(1, 2, 3, 4, 5, 6)
        // when
        val grade = lotto.scratch(winningNumber)
        // then
        grade shouldBe LottoGrade.FIST_GRADE
    }

    "숫자 6개의 리스트가 아닌 경우 예외를 발생한다" {
        shouldThrow<IllegalArgumentException> {
            Lotto(StaticLottoNumberGenerator(listOf(1, 2, 3, 4, 5)).pick())
        }.shouldHaveMessage("숫자는 6개가 존재해야 합니다")
    }

    "숫자범위를 넘기는 경우 예외를 발생한다" {
        shouldThrow<IllegalArgumentException> {
            Lotto(StaticLottoNumberGenerator(listOf(51, 2, 3, 4, 5, 6)).pick())
        }.shouldHaveMessage("로또 번호 범위에 맞지 않는 숫자가 존재 합니다")
    }
})
