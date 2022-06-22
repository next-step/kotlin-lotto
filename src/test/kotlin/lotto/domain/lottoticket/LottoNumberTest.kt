package lotto.domain.lottoticket

import io.kotest.assertions.throwables.shouldNotThrowAny
import io.kotest.assertions.throwables.shouldThrowExactly
import io.kotest.core.spec.style.FreeSpec
import io.kotest.data.row
import io.kotest.inspectors.forAll
import io.kotest.matchers.collections.shouldContainExactly
import io.kotest.matchers.shouldBe
import io.kotest.matchers.types.shouldBeSameInstanceAs

internal class LottoNumberTest : FreeSpec({
    "로또 숫자는 1~45 사이의 정수로만 이루어진다." {
        // given
        val lottoNumberRange = (1..45)

        // when, when
        shouldNotThrowAny { lottoNumberRange.map { LottoNumber.from(value = it) } }
    }

    "로또 숫자로 1~45 사이 이외의 정수가 주어지면 예외가 발생한다." - {
        listOf(
            0,
            46,
            1000
        ).forAll { number ->
            "'$number' 는 예외가 발생한다." {
                val exception =
                    shouldThrowExactly<IllegalArgumentException> { LottoNumber.from(value = number) }
                exception.message shouldBe "로또 숫자의 범위는 1 ~ 45 입니다."
            }
        }
    }

    "같은 로또 번호에 대해서는 같은 인스턴스 객체를 반환한다." - {
        listOf(
            row(1, 1),
            row(2, 2),
            row(10, 10),
            row(45, 45),
        ).forEach { (firstNumber, secondNumber) ->
            "'$firstNumber'와 '$secondNumber'의 인스턴스는 같다." {
                LottoNumber.from(value = firstNumber) shouldBe LottoNumber.from(value = secondNumber)
                LottoNumber.from(value = firstNumber) shouldBeSameInstanceAs LottoNumber.from(value = secondNumber)
            }
        }
    }

    "1~45 까지의 로또번호가 담긴 리스트를 반환한다." {
        // given
        val expectedLottoNumbers = (1..45).map { LottoNumber.from(value = it) }

        // when
        val lottoNumbers = LottoNumber.cachedLottoNumbers()

        // then
        lottoNumbers.shouldContainExactly(expectedLottoNumbers)
    }
})
