package lotto.domain

object ExceptionType {
    const val INPUT_MUST_NOT_NULL = "입력이 비어서는 안됩니다."
    const val INPUT_MUST_UNSIGNED_INT = "금액 입력은 양의 정수 여야만 합니다."
    const val NUMBER_OF_MANUAL_SELECT_GAME_MUST_UNSIGNED_INT = "수동 선택 게임 수는 0이상의 정수 여야 합니다."
    const val NUMBER_OF_MANUAL_SELECT_GAME_MUST_LESS_THEN_FULL_GAME_NUMBER = "수동 선택 게임 수는 전체 구매 가능 수 보다 적어야합니다."
    const val CAN_NOT_ADD_MANUAL_GAME_MORE_THEN_FIXED_NUMBER = "수동 선택 게임 수보다 수동 게임 번호를 더 추가 할 수 없습니다."
    const val BUDGET_UNSIGNED_INT = "복권 구매 값은 양의 정수 여야만 합니다."
    const val LAST_WEEK_NUMBERS_MUST_IN_RANGE = "저번 주 숫자는 1~45 여야만 합니다."
    const val LAST_WEEK_INPUT_NUMBERS_SIZE_MUST_SIX = "저번 주 숫자는 6개의 숫자 여야만 합니다."
    const val SIZE_OF_LOTTO_GAME_MUST_SIX = "로또 한 게임의 숫자는 중복 되지 않는 6개의 숫자 여야만 합니다."
    const val LAST_WEEK_NUMBERS_SIZE_MUST_SIX = "저번 주 숫자는 중복되지 않는 6개의 숫자 여야만 합니다."
    const val BONUS_NUMBER_MUST_NOT_CONTAINED_BY_LAST_WEEK_NUMBERS = "보너스는 저번 주 당첨 숫자에 포함되지 않아야 합니다."
    const val NOT_DEFINED_HIT = "당첨 갯수가 아닙니다."
}
