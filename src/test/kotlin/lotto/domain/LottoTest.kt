package lotto.domain

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.FreeSpec
import io.kotest.matchers.shouldBe
import io.kotest.matchers.shouldNotBe
import lotto.domain.LottoNumberSupports.toLottoNumbers

class LottoTest : FreeSpec({

    "서로 다른 로또 번호 6개 조합으로 구성된다." {
        val lottoNumbers = (1..6).toLottoNumbers()
        val lotto = Lotto(lottoNumbers)
        lotto shouldNotBe null
    }

    "서로 다른 로또 번호 6개 조합으로 구성된다. (번호 중복)" {
        val lottoNumbers = listOf(1, 1, 2, 3, 4, 5, 6).toLottoNumbers()
        val throws = shouldThrow<IllegalArgumentException> { Lotto(lottoNumbers) }
        throws.message shouldBe "서로 다른 6개의 숫자를 입력해야 합니다."
    }

    "서로 다른 로또 번호 6개 조합으로 구성된다. (6개 미만)" {
        val lottoNumbers = (3..6).toLottoNumbers()
        val throws = shouldThrow<IllegalArgumentException> { Lotto(lottoNumbers) }
        throws.message shouldBe "서로 다른 6개의 숫자를 입력해야 합니다."
    }

    "서로 다른 로또 번호 6개 조합으로 구성된다. (6개 초과)" {
        val lottoNumbers = (1..7).toLottoNumbers()
        val throws = shouldThrow<IllegalArgumentException> { Lotto(lottoNumbers) }
        throws.message shouldBe "서로 다른 6개의 숫자를 입력해야 합니다."
    }

    "작은 번호 순서로 정렬된다." {
        val lottoNumbers = listOf(10, 3, 4, 5, 2, 6).toLottoNumbers()
        Lotto(lottoNumbers).numbers shouldBe listOf(2, 3, 4, 5, 6, 10).toLottoNumbers()
    }
})
