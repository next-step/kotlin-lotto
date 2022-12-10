package step2.lotto.domain

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.data.forAll
import io.kotest.data.row
import io.kotest.matchers.types.shouldBeSameInstanceAs

internal class LottoNumberTest : StringSpec({
    "같은 번호로 로또 객체를 생성하면 동일한 객체가 반환된다." {
        val given = 45
        LottoNumber.of(given) shouldBeSameInstanceAs LottoNumber.of(given)
    }

    "1~45범위를 넘어서는 로또 번호 객체 생성시 예외가 발생한다." {
        forAll(
            row(0), row(46)
        ) { given: Int ->
            shouldThrow<IllegalArgumentException> { LottoNumber.of(given) }
        }
    }
})
