package lotto

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class LottoCreatorTest : StringSpec({
    "입력된 개수만큼의 로또를 생성할 수 있다." {
        val lottoCreator = LottoCreator(FixedNumberGenerator())

        val result = lottoCreator.createLottos(5)

        result.size shouldBe 5
    }
})
