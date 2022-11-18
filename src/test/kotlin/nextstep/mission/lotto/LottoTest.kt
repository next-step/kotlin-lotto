package nextstep.mission.lotto

import io.kotest.assertions.throwables.shouldThrowExactly
import io.kotest.core.spec.style.StringSpec

class LottoTest : StringSpec({

    "로또는 숫자 여섯자리를 관리한다." {
        shouldThrowExactly<IllegalArgumentException> {
            Lotto(listOf(1, 3, 10, 33, 1))
        }
    }
})
