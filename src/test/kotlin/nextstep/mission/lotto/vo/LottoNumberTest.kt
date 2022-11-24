package nextstep.mission.lotto.vo

import io.kotest.assertions.throwables.shouldNotThrowAny
import io.kotest.assertions.throwables.shouldThrowExactly
import io.kotest.core.spec.style.StringSpec
import io.kotest.property.Exhaustive
import io.kotest.property.checkAll
import io.kotest.property.exhaustive.ints

class LottoNumberTest : StringSpec({

    "로또 번호 생성 시 1미만, 45초과면 예외가 발생한다." {
        listOf(0, 46).forEach { wrongLottoNumber: Int ->
            shouldThrowExactly<IllegalArgumentException> { LottoNumber(wrongLottoNumber) }
        }
    }

    "로또 번호는 1이상, 45이하 숫자를 갖는다." {
        checkAll(Exhaustive.ints(1..45)) {
            shouldNotThrowAny { LottoNumber(it) }
        }
    }
})
