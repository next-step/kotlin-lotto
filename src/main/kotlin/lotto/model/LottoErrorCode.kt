package lotto.model

enum class LottoErrorCode(val message: (String) -> String) {
    INVALID_LOTTERY_NUMBER(
        message = { input -> "정해진 로또 번호 개수가 아니거나 중복된 숫자를 입력하셨습니다. (입력 개수) (제한 개수) : $input" },
    ),
    INVALID_LOTTO_NUMBER(
        message = { input -> "로또 번호는 정해진 범위 안에 숫자여야 합니다. (범위) (입력값) : $input" },
    ),
}
