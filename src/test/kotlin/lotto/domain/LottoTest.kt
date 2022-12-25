package lotto.domain

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

class LottoTest : DescribeSpec({
    it("로또는 6개의 숫자로 만들어진다.") {
        val lottoNumbers = (1..6).map { LottoNumber.of(it) }.toSet()

        Lotto(lottoNumbers)
    }

    it("6개의 숫자가 아닐 경우 로또를 생성할 수 없다.") {
        val lottoNumbers = (1..4).map { LottoNumber.of(it) }.toSet()

        shouldThrow<java.lang.IllegalArgumentException> {
            Lotto(lottoNumbers)
        }
    }

    it("로또 간에 겹치는 로또 넘버의 갯수를 찾을 수 있다.") {
        val lottoNumbers = (1..6).map { LottoNumber.of(it) }.toSet()
        val lotto = Lotto(lottoNumbers)

        val otherNumbers = (4..9).map { LottoNumber.of(it) }.toSet()
        val other = Lotto(otherNumbers)

        lotto.intersect(other) shouldBe 3
    }

    it("로또 안에 특정 로또 넘버가 있는지 확인할 수 있다.") {
        val lottoNumbers = (1..6).map { LottoNumber.of(it) }.toSet()
        val lotto = Lotto(lottoNumbers)

        lotto.contains(LottoNumber.of(1)) shouldBe true
        lotto.contains(LottoNumber.of(7)) shouldBe false
    }
})
