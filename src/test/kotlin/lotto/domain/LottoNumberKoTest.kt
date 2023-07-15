package lotto.domain

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.inspectors.forAll

class LottoNumberKoTest : StringSpec({
    "1부터 45사이의 숫자로 로또 넘버 생성 성공" {
        listOf(1, 2, 45).forAll {
            LottoNumber(it)
        }
    }

    "1부터 45 범위를 벗어난 숫자를 입력하면 에러" {
        listOf(-1, 0, 46).forAll {
            shouldThrow<IllegalArgumentException> {
                LottoNumber(it)
            }
        }
    }
})
