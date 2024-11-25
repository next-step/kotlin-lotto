package lotto

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class BonusNumberTest : StringSpec({
    "보너스 볼을 생성한다." {
        BonusNumber(LottoNumber(1))
    }

    "로또 번호와 일치하는지 확인한다." {
        val sut = BonusNumber(LottoNumber(1))

        val lotto = Lotto(listOf(1, 2, 3, 4, 5, 6))
        val actual = sut.isMatch(lotto)

        actual shouldBe true
    }
})
