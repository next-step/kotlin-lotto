package lotto

import io.kotest.core.spec.style.StringSpec
import io.kotest.inspectors.forAll
import io.kotest.matchers.ints.shouldBeInRange
import io.kotest.matchers.shouldBe
import lotto.domain.LottoMachine

class LottoMachineTest : StringSpec({
    "1~45 사이의 랜덤 숫자 6개를 반환한다."{
        //given
        val lottoMachine = LottoMachine()
        //when
        val lottoNumbers = lottoMachine.purchase(1).lottoTickets[0]
        //then
        lottoNumbers.lottoNumbers.size shouldBe 6
        lottoNumbers.lottoNumbers.forAll { it.value shouldBeInRange 1..45 }
    }

})
