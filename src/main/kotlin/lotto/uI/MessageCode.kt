package lotto.uI

import lotto.domain.LottoStatistics

enum class MessageCode(val message: String) {
    INPUT_MONEY("구입금액을 입력해 주세요"),
    INPUT_MANUAL_LOTTO_COUNT("수동으로 구매할 로또 수를 입력해 주세요."),
    INPUT_MANUAL_LOTTO_NUMBERS("수동으로 구매할 번호를 입력해 주세요."),
    PURCHASE_COUNT_RESULT("개를 구매했습니다."),
    INPUT_LAST_WEEK_LOTTO("지난 주 당첨 번호를 입력해 주세요."),
    INPUT_BONUS_LOTTO_NUMBER("보너스 볼을 입력해 주세요."),
    RESULT_STATISTICS("당첨 통계"),
    RESULT_STANDARD_PROFIT_RATIO("(기준이 ${LottoStatistics.STANDARD_PROFIT_RATIO}이기 때문에 결과적으로 손해라는 의미임)"),
    BONUS_BALL_MATCH(", 보너스 볼 일치")
}
