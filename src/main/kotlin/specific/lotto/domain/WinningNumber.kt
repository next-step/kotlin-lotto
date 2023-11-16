package specific.lotto.domain

import requireNotNullAndNotBlank
import toIntOrThrow

data class WinningNumber(val lottoNumber: LottoNumber) {
    constructor(lottoNumberValues: String?) : this(
        lottoNumberValues
            .requireNotNullAndNotBlank { "'lottoNumber' cannot be null or blank" }
            .split(", ")
            .map { it.toIntOrThrow { "'lottoNumber' should be convertible to Int" } }
            .let { LottoNumber(it) }
    )

}
