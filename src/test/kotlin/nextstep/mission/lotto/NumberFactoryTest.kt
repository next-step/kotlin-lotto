package nextstep.mission.lotto

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class NumberFactoryTest : StringSpec({

    "숫자 생성기는 랜덤숫자 6자리를 생성한다." {
        NumberFactory.create().size shouldBe 6
    }
})
