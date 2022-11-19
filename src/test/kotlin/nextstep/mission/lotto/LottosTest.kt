package nextstep.mission.lotto

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class LottosTest : StringSpec({

    "로또를 입력받은 금액만큼의 갯수를 관리한다." {
        Lottos(10000).lottos.size shouldBe 10
    }
})
