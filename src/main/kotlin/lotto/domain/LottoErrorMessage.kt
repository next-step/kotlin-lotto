package lotto.domain

object LottoErrorMessage {
    const val LOTTO_NUMBERS_MUST_BE_6: String = "로또 번호는 6개여야 합니다."
    const val LOTTO_NUMBERS_MUST_BE_POSITIVE: String = "로또 번호는 양수여야 합니다."
    const val LOTTO_NUMBERS_MUST_BE_BETWEEN_1_AND_45: String = "로또 번호는 1~45 사이의 숫자여야 합니다."
    const val BUNUS_NUMBERS_MUST_NOT_DIFFERENT_FROM_WINNING_NUMBER: String = "보너스 번호는 당첨 번호와 중복되지 않아야 합니다."
}
