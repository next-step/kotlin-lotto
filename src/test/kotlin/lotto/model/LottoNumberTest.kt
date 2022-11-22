package lotto.model

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.inspectors.forAll
import io.kotest.matchers.shouldBe
import io.kotest.matchers.throwable.shouldHaveMessage

class LottoNumberTest : StringSpec({

    "로또넘버 객채를 생성하면, 중복없는 숫자 6개를 같는다" {
        // given
        val lottoNumber = LottoNumber(StaticLottoNumberGenerator(listOf(1, 2, 3, 4, 5, 6)).pick())
        // expect
        lottoNumber.number.distinct().size shouldBe 6
    }

    "중복없는 숫자 6개의 리스트가 아닌 경우 예외를 발생한다" {
        listOf(
            listOf(1, 2, 3, 4, 5),
            listOf(1, 2, 3, 4, 5, 1)
        ).forAll {
            shouldThrow<IllegalArgumentException> {
                LottoNumber(StaticLottoNumberGenerator(it).pick())
            }.shouldHaveMessage("중복없는 숫자는 6개가 존재해야 합니다")
        }
    }

    "숫자범위를 넘기는 경우 예외를 발생한다" {
        shouldThrow<IllegalArgumentException> {
            LottoNumber(StaticLottoNumberGenerator(listOf(51, 2, 3, 4, 5, 6)).pick())
        }.shouldHaveMessage("로또 번호 범위에 맞지 않는 숫자가 존재 합니다")
    }
})
