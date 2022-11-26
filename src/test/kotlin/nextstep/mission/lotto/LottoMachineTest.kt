package nextstep.mission.lotto

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class LottoMachineTest : StringSpec({

    "로또 기계는 입력받은 금액만큼의 로또 숫자 리스트를 자동 생성한다." {
        val totalLottoPrice = 10_000

        val result: Lotto = LottoMachine.create(totalLottoPrice)

        result.lottoNumbers.size shouldBe 10
    }
})
