package lotto.domain

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import lotto.domain.Lotto.Companion.LOTTO_NUMBER_COUNT

class LottoNumbersTest : StringSpec({
    val lotto = Lotto(
        setOf(
            LottoNumber(6), LottoNumber(5),
            LottoNumber(4), LottoNumber(3),
            LottoNumber(2), LottoNumber(1)
        )
    )

    val winningLotto = Lotto(
        setOf(
            LottoNumber(45), LottoNumber(44),
            LottoNumber(4), LottoNumber(3),
            LottoNumber(2), LottoNumber(1)
        )
    )

    "로또의 번호는 정렬 되어야 한다." {
        lotto.lottoNumbers.first().value shouldBe 1
        lotto.lottoNumbers.last().value shouldBe 6
    }

    "로또의 번호는 6자리 여야 한다." {
        lotto.size() shouldBe 6
    }

    "로또의 번호와 당첨 번호를 사용하여 당첨 번호의 갯수를 확인한다." {
        lotto.removeAll(winningLotto)

        LOTTO_NUMBER_COUNT.minus(lotto.size()) shouldBe 4
    }
})
