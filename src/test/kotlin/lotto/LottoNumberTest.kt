package lotto

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import lotto.domain.LottoNumber
import org.junit.jupiter.api.assertAll
import kotlin.IllegalArgumentException

internal class LottoNumberTest : StringSpec({
    "LottoNumber 생성 시 1~45 이외의 숫자가 입력되면 IllegalArgumentException이 발생한다." {
        assertAll(
            {shouldThrow<IllegalArgumentException> { LottoNumber(0) }},
            {shouldThrow<IllegalArgumentException> { LottoNumber(46) }}
        )
    }
})
