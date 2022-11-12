package lotto

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.ints.shouldBeInRange
import io.kotest.matchers.shouldBe

class LottoNumberGeneratorTest : StringSpec({
    "1~45 사이의 랜덤 숫자 6개를 반환한다."{
        //when
        val lottoNumbers = LottoNumberGenerator.generateNumbers()
        //then
        lottoNumbers.size shouldBe 6
        lottoNumbers[0] shouldBeInRange 1..45
        lottoNumbers[1] shouldBeInRange 1..45
        lottoNumbers[2] shouldBeInRange 1..45
        lottoNumbers[3] shouldBeInRange 1..45
        lottoNumbers[4] shouldBeInRange 1..45
        lottoNumbers[5] shouldBeInRange 1..45
    }

})
