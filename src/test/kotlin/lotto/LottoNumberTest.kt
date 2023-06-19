package lotto

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.FunSpec
import io.kotest.data.forAll
import io.kotest.data.row
import io.kotest.matchers.shouldBe

class LottoNumberTest : FunSpec({
    test("로또번호에 1~45 외 다른 숫자를 담으면 예외가 발생한다") {
        forAll(
            row(0),
            row(46),
        ) { number ->
            val exception = shouldThrow<IllegalArgumentException> { LottoNumber(number) }

            exception.message shouldBe "1~45 범위 숫자여야 합니다."
        }
    }

    test("보너스 로또번호와 당첨 로또번호가 중복되면 예외가 발생한다") {
        val exception = shouldThrow<IllegalArgumentException> {
            LottoNumber.forBonusOf(
                number = 9,
                winningLotto = Lotto.of(listOf(1, 2, 3, 4, 5, 9))
            )
        }

        exception.message shouldBe "당첨 로또 번호와 보너스 번호는 중복될 수 없습니다."
    }
})
