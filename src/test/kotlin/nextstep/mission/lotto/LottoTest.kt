package nextstep.mission.lotto

import io.kotest.assertions.throwables.shouldNotThrowAny
import io.kotest.assertions.throwables.shouldThrowExactly
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class LottoTest : StringSpec({

    "로또는 숫자 여섯자리를 관리한다." {
        val exception = shouldThrowExactly<IllegalArgumentException> {
            Lotto(listOf(1, 3, 10, 33, 11))
        }
        exception.message shouldBe "로또 숫자는 6개여야 합니다."
    }

    "로또는 중복 숫자를 가질 수 없다." {
        val exception = shouldThrowExactly<IllegalArgumentException> {
            Lotto(listOf(1, 3, 10, 33, 1, 11))
        }
        exception.message shouldBe "로또 숫자는 중복이 허용되지 않습니다."
    }

    "로또의 숫자 범위는 1에서 45 사이다." {
        val exception = shouldThrowExactly<IllegalArgumentException> {
            Lotto(listOf(1, 3, 10, 33, 23, 46))
        }
        exception.message shouldBe "로또 숫자는 1에서 45사이어야 합니다."
    }

    "로또는 위 벨리데이션을 모두 통과 시 정상 생성한다." {
        shouldNotThrowAny {
            Lotto(listOf(1, 2, 3, 4, 5, 6))
        }
    }
})
