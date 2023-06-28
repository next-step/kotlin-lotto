package lotto.domain

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import lotto.domain.LottoNumbers.Companion.LOTTO_NUMBER_COUNT

class LottoNumbersTest : StringSpec({
    val lottoNumbers = LottoNumbers(
        setOf(
            LottoNumber(6), LottoNumber(5),
            LottoNumber(4), LottoNumber(3),
            LottoNumber(2), LottoNumber(1)
        )
    )

    val winningLottoNumbers = LottoNumbers(
        setOf(
            LottoNumber(45), LottoNumber(44),
            LottoNumber(4), LottoNumber(3),
            LottoNumber(2), LottoNumber(1)
        )
    )

    "로또의 번호는 정렬 되어야 한다." {
        lottoNumbers.lottoNumbers.first().value shouldBe 1
        lottoNumbers.lottoNumbers.last().value shouldBe 6
    }

    "로또의 번호는 6자리 여야 한다." {
        lottoNumbers.size() shouldBe 6
    }

    "로또의 번호와 당첨 번호를 사용하여 당첨 번호의 갯수를 확인한다." {
        lottoNumbers.removeAll(winningLottoNumbers)

        LOTTO_NUMBER_COUNT.toInt().minus(lottoNumbers.size()) shouldBe 4
    }
})
