package lotto

import io.kotest.core.spec.style.StringSpec
import io.kotest.inspectors.forAll
import io.kotest.matchers.ints.shouldBeInRange
import io.kotest.matchers.shouldBe
import lotto.util.LottoNumberGenerator

class LottoNumberGeneratorTest : StringSpec({
    "1~45 사이의 랜덤 숫자 6개를 반환한다."{
        //when
        val lottoNumbers = LottoNumberGenerator.generate(1)[0].toList()
        //then
        lottoNumbers.size shouldBe 6
        lottoNumbers.forAll { it shouldBeInRange 1..45 }
    }

})
