package lotto.domain

@JvmInline
value class BonusNumber(val value: Int) {
    init {
        require(value in LottoNumbers.LOTTO_START_NUMBER..LottoNumbers.LOTTO_END_NUMBER) { "로또에는 1 ~ 45 사이의 숫자만 적힐 수 있습니다" }
    }

    infix fun notIn(winningNumbers: LottoNumbers): Boolean =
        !winningNumbers.value.contains(value)
}
