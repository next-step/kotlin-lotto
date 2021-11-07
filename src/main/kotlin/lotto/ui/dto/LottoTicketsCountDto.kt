package lotto.ui.dto

import lotto.domain.LottoTicketsCount

data class LottoTicketsCountDto(val manual: Int, val auto: Int) {
    constructor(count: LottoTicketsCount) : this(manual = count.manual.value, auto = count.auto.value)
}
