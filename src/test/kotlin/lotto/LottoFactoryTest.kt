package lotto

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class LottoFactoryTest : FunSpec({
    test("로또 생성기는 6개의 숫자를 골라 로또 한 장을 생성한다.") {
        val lotto = generateLottoList().first()
        lotto.numbers.size shouldBe 6
    }
})
