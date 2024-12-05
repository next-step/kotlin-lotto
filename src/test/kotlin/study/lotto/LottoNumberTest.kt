package study.lotto

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.should
import io.kotest.matchers.shouldBe
import io.kotest.matchers.string.startWith
import study.lotto.model.LottoNumber

/**
 * @author 이상준
 */
class LottoNumberTest : StringSpec({
    "Lotto Number 46 ~ 70 테스트" {
        for (it in 46..70) {
            val exception =
                shouldThrow<IllegalArgumentException> {
                    LottoNumber(it)
                }
            exception.message should startWith("로또 번호는 1부터 45까지 가능합니다.")
        }
        val exception =
            shouldThrow<IllegalArgumentException> {
                LottoNumber(46)
            }
        exception.message should startWith("로또 번호는 1부터 45까지 가능합니다.")
    }
    "Lotto Number 0  테스트" {
        val exception =
            shouldThrow<IllegalArgumentException> {
                LottoNumber(0)
            }
        exception.message should startWith("로또 번호는 1부터 45까지 가능합니다.")
    }
    "Lotto Number 테스트" {
        val lottoNumber = LottoNumber(1)

        lottoNumber.number shouldBe 1
    }
})
