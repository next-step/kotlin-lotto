package lotto.domain

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.collections.shouldContainAll
import io.kotest.matchers.shouldBe

class LottoTest : StringSpec({
    "로또를 자동으로 생성한다" {
        Lotto.auto().lottoNumbers.numbers.size shouldBe 6
    }

    "로또를 수동으로 생성한다" {
        val lotto =
            Lotto.manual(LottoNumbers.from(setOf(1, 2, 3, 4, 5, 6)))
        lotto.lottoNumbers.numbers shouldContainAll
            setOf(
                LottoNumber(1),
                LottoNumber(2),
                LottoNumber(3),
                LottoNumber(4),
                LottoNumber(5),
                LottoNumber(6),
            )
    }
})
