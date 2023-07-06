package lotto.domain

import lotto.view.ExceptionMessage

@JvmInline
value class ManualLottoCount(val count: Int) {
    init {
        require(count > -1) { ExceptionMessage.REQUIRE_POSITIVE_NUMBER.message }
    }
}
