package lotto.model

enum class LottoErrorCode(val message: (String) -> String) {
    INVALID_LOTTERY_NUMBER(
        message = { input -> "정해진 로또 번호 개수가 아니거나 중복된 숫자를 입력하셨습니다. (입력 개수) (제한 개수) : $input" },
    ),
    INVALID_LOTTO_NUMBER(
        message = { input -> "로또 번호는 정해진 범위 안에 숫자여야 합니다. (범위) (입력값) : $input" },
    ),
    NOT_INCLUDE_RANGE_COUNT_OF_MATCH(
        message = { input -> "당첨 개수 범위에 포함되지 않습니다. (범위) (입력값) : $input" },
    ),
    MUST_NOT_BE_INCLUDE_WINNING_NUMBER(
        message = { input -> "보너스 볼은 당첨 번호에 포함되면 안 됩니다. (당첨 볼) (당첨 번호) : $input" },
    ),
}
