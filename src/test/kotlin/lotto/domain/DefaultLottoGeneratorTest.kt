package lotto.domain

import io.kotest.assertions.throwables.shouldNotThrow
import io.kotest.core.spec.style.StringSpec

class DefaultLottoGeneratorTest : StringSpec({
    "로또 생성기는 중복되지 않는 유효한 숫자 6개로 이루어진 리스트를 생성한다." {
        shouldNotThrow<IllegalArgumentException> { DefaultLottoGenerator.generate(Lotto.LOTTO_SIZE) }
    }
})
