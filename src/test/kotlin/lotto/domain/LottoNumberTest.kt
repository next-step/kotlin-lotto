package lotto.domain

import io.kotest.assertions.throwables.shouldNotThrowAny
import io.kotest.assertions.throwables.shouldThrowAny
import io.kotest.core.spec.style.StringSpec
import io.kotest.inspectors.forAll

class LottoNumberTest : StringSpec({
    "로또 번호는 1~45 사이 값이여야 한다." {
        (1..45).toList().forAll { lottoNumber ->
            shouldNotThrowAny { LottoNumber(lottoNumber) }
        }
    }

    "1~45이 아닌 값으로 로또 번호를 생성할시 에러가 발생한다." {
        (-45..0).toList().forAll { lottoNumber ->
            shouldThrowAny { LottoNumber(lottoNumber) }
        }
        (46..100).toList().forAll { lottoNumber ->
            shouldThrowAny { LottoNumber(lottoNumber) }
        }
    }
})
