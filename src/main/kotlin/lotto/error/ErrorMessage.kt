package lotto.error

enum class ErrorMessage(val message: String) {
    EMPTY_INPUT_MESSAGE("입력값이 비어있어용ㅇ오오오옹~~~~~~~~"),
    EXPECT_NUMBER_MESSAGE("이노옴~~~ 숫자만 입력해야지!!"),
    MIN_LOTTO_COUNT("최소 1개는 로또를 사야지!!!!!!!"),
    LOTTO_RANGE_ERROR("로또 번호는 1 ~ 45 사이의 숫자여야 합니다"),
    LOTTO_COUNT_ERROR("로또의 개수는 6개 입니다"),
}
