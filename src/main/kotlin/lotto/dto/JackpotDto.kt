package lotto.dto

import lotto.domain.JackpotLevel

data class JackpotDto(val jackpot: List<JackpotLevel>) {
    constructor(jackpotLevel: JackpotLevel) : this(
        JackpotLevel.values().filter { it == jackpotLevel }
    )
}
