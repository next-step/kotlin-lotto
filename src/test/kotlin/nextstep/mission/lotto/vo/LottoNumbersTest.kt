package nextstep.mission.lotto.vo

import io.kotest.assertions.throwables.shouldThrowExactly
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import io.kotest.property.Arb
import io.kotest.property.arbitrary.subsequence
import io.kotest.property.checkAll

class LottoNumbersTest : StringSpec({

    "로또 숫자들이 6개가 아니면 예외가 발생한다." {
        checkAll(10, Arb.subsequence(lottoNumbersOf(1, 2, 3, 4, 5))) {
            val exception = shouldThrowExactly<IllegalArgumentException> {
                LottoNumbers(it)
            }

            exception.message shouldBe "로또 숫자는 6개여야 합니다."
        }
    }

    "로또 숫자들 중복이면 예외가 발생한다." {
        val exception = shouldThrowExactly<IllegalArgumentException> {
            LottoNumbers(lottoNumbersOf(1, 2, 3, 4, 5, 5))
        }

        exception.message shouldBe "로또 숫자는 중복이 허용되지 않습니다."
    }

    "로또는 당첨번호를 입력받아 몇개의 숫자가 일치하는지 반환한다." {
        val lottoNumbers = LottoNumbers(lottoNumbersOf(1, 2, 3, 4, 5, 6))

        val result: Int = lottoNumbers.match(LottoNumbers(lottoNumbersOf(1, 2, 3, 4, 5, 6)))

        result shouldBe 6
    }
})

private fun lottoNumbersOf(vararg elements: Int): List<LottoNumber> =
    elements.map { LottoNumber(it) }
