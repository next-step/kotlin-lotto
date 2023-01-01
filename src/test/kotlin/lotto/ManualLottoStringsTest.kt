package lotto

import io.kotest.core.spec.style.StringSpec
import lotto.domain.ManualLottoStrings
import org.assertj.core.api.Assertions

class ManualLottoStringsTest : StringSpec({

    "수동 입력 개수와 입력받은 로또 숫자목록 개수는 같다" {
        Assertions.assertThatExceptionOfType(IllegalArgumentException::class.java)
            .isThrownBy { ManualLottoStrings(3, listOf("1,2,3,4,5,6", "1,2,3,4,5,6")) }
    }
})
