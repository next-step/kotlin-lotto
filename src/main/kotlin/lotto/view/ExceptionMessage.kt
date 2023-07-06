package lotto.view

enum class ExceptionMessage(val message: String) {
    REQUIRE_NUMBER_RANGE("1~45 사이의 숫자를 입력해 주세요."),
    REQUIRE_POSITIVE_NUMBER("0 이상의 숫자를 입력해 주세요."),
    DUPLICATE_NUMBER_OR_NOT_SIX("로또 번호에 중복된 번호가 있거나 숫자의 갯수가 6개가 아닙니다."),
    REQUIRE_MORE_THAN_1000("1000원 이상의 금액을 입력해 주세요."),
    DUPLICATE_NUMBER_AND_BONUS("당첨 번호와 중복되는 번호를 입력했습니다."),
    EXCEEDED_MAXIMUM_AVAILABLE_PURCHASES("최대 구매 가능 갯수를 넘었습니다."),
}
