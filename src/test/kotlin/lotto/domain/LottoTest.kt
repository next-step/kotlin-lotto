package lotto.domain

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.DescribeSpec

class LottoTest : DescribeSpec({
    it("로또는 6개의 숫자로 만들어진다.") {
        val lottoNumbers = (1..6).map { LottoNumber(it) }.toSet()

        Lotto(lottoNumbers)
    }

    it("6개의 숫자가 아닐 경우 로또를 생성할 수 없다.") {
        val lottoNumbers = (1..4).map { LottoNumber(it) }.toSet()

        shouldThrow<java.lang.IllegalArgumentException> {
            Lotto(lottoNumbers)
        }
    }
})
