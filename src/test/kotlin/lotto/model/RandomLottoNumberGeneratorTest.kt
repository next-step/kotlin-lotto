package lotto.model

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class RandomLottoNumberGeneratorTest : StringSpec({

    "로또번호 생성기는, 번호를 선택하면, 1~45 사이의 숫자 중 중복되지 않는 6개를 반환한다" {
        // given
        val lottNumberGenerator = RandomLottoNumberGenerator()
        // when
        val number = lottNumberGenerator.pick()
        // then
        number.size() shouldBe 6
    }
})
