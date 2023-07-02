package lotto.view

enum class InputMessage(val message: String) {
    PURCHASE_AMOUNT("구입금액을 입력해 주세요."),
    WINNING_NUMBERS("지난 주 당첨 번호를 입력해 주세요."),
    BONUS_NUMBER("보너스 볼을 입력해 주세요."),
    MANUAL_LOTTO_COUNT("수동으로 구매할 로또 수를 입력해 주세요."),
    LOTTO_NUMBER("수동으로 구매할 번호를 입력해 주세요.")
}
