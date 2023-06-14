package lotto.model

enum class LottoErrorCode(val message: (String) -> String) {
    INVALID_PURCHASE_AMOUNT(
        message = { input -> "구매금액은 숫자 또는 2,147,483,647보다 작은 수를 입력해 주세요. (입력값) : $input" },
    ),
    INVALID_LOTTERY_NUMBER(
        message = { input -> "정해진 로또 번호 개수가 아니거나 중복된 숫자를 입력하셨습니다. (입력 개수) (제한 개수) : $input" },
    ),
    INVALID_LOTTO_NUMBER(
        message = { input -> "로또 번호는 정해진 범위 안에 숫자여야 합니다. (범위) (입력값) : $input" },
    ),
    INVALID_INPUT_NUMBER(
        message = { input -> "입력한 로또 번호는 숫자여야 합니다. (입력값) : $input" },
    ),
}
