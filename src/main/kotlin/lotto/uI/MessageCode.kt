package lotto.uI

enum class MessageCode(val message: String) {
    INPUT_MONEY("구입금액을 입력해 주세요"),
    PURCHASE_COUNT_RESULT("개를 구매했습니다."),
    INPUT_LAST_WEEK_LOTTO("지난 주 당첨 번호를 입력해 주세요."),
    RESULT_STATISTICS("당첨 통계")
}
