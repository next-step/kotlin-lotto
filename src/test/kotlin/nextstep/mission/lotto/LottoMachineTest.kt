package nextstep.mission.lotto

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import nextstep.mission.lotto.vo.LottoNumbers

class LottoMachineTest : StringSpec({

    "로또 기계는 로또 숫자 리스트(6자리) 하나를 자동 생성한다." {
        val result: LottoNumbers = LottoMachine.create()

        result.numbers.size shouldBe 6
    }
})
