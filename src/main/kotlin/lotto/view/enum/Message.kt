package lotto.view.enum

enum class Message(val message: String) {
    QUESTION_MONEY("구입금액을 입력해 주세요."),
    QUESTION_MANUAL_COUNT("수동으로 구매할 로또 수를 입력해 주세요."),
    QUESTION_MANUAL_LOTTO_NUMBER("수동으로 구매할 번호를 입력해 주세요."),
    QUESTION_WINNING_NUMBER("지난 주 당첨 번호를 입력해 주세요."),
    QUESTION_BONUS_NUMBER("보너스 볼을 입력해 주세요."),
    SUMMARY_BUYING_LOTTO("수동으로 [0]장, 자동으로 [1]개를 구매했습니다."),
    MISMATCHED_VARIABLE_COUNT("변수의 개수가 일치하지 않습니다."),
    LOTTO_PURCHASE_ERROR("주어진 돈으로 살 수 없는 로또 개수입니다.")
}
