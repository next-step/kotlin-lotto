package lotto.model

import io.kotest.assertions.throwables.shouldNotThrowAny
import io.kotest.assertions.throwables.shouldThrowExactly
import io.kotest.core.spec.DisplayName
import io.kotest.core.spec.style.StringSpec
import io.kotest.inspectors.forAll
import io.kotest.matchers.collections.shouldContainExactly

@DisplayName("로또 번호")
class LottoNumberTest : StringSpec({

    "1 ~ 45 사이의 숫자로 생성 가능" {
        listOf(1, 10, 20, 45).forAll {
            shouldNotThrowAny {
                LottoNumber(it)
            }
        }
    }

    "1 ~ 45 사이의 숫자가 아니면 예외 발생" {
        listOf(Int.MIN_VALUE, -1, 0, 46, Int.MAX_VALUE).forAll {
            shouldThrowExactly<IllegalArgumentException> {
                LottoNumber(it)
            }
        }
    }

    "로또 번호 범위 생성" {
        // given
        val start = LottoNumber(1)
        val end = LottoNumber(5)
        // when
        val lottoNumbers: Collection<LottoNumber> = start..end
        // then
        lottoNumbers shouldContainExactly listOf(
            LottoNumber(1),
            LottoNumber(2),
            LottoNumber(3),
            LottoNumber(4),
            LottoNumber(5)
        )
    }
})
