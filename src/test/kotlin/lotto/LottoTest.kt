package lotto

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class LottoTest : StringSpec({
    val lotto = Lotto()

    "'로또 1장은 총 6개의 숫자가 무작위로 출력된다.'" {
        lotto.generateCachedLottoNumbers().size shouldBe 6
    }

    "'로또 번호는 1부터 45 사이의 숫자만 포함해야 한다.'" {
        val validNumbers = lotto.generateCachedLottoNumbers().all { it in 1..45 }
        validNumbers shouldBe true
    }
})
