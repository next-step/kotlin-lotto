package lotto.domain

import lotto.domain.LottoNumbers.Companion.DELIMITER
import lotto.domain.LottoNumbers.Companion.MAXIMUM_LOTTO_NUMBER_LENGTH

@JvmInline
value class WinningNumbers(private val value: List<LottoNumber>) {
    init {
        require(value.size == MAXIMUM_LOTTO_NUMBER_LENGTH) { "당첨 번호는 6개의 숫자여야 합니다." }
        require(value.distinct().size == MAXIMUM_LOTTO_NUMBER_LENGTH) { "당첨 번호는 중복될 수 없습니다." }
    }

    constructor(value: String) : this(
        value.split(DELIMITER)
            .map { LottoNumber(it.toIntOrNull() ?: throw IllegalArgumentException("숫자 이외의 값은 입력할 수 없습니다.")) }
    )

    fun contains(lottoNumbers: LottoNumbers): Int {
        return value.count { lottoNumbers.value.contains(it) }
    }
}
