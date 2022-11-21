package lotto.util

import lotto.domain.LottoGenerator
import lotto.domain.LottoPurchase

enum class ErrorCode(val errorMessage: String) {
    MONEY_INPUT_FORMAT_EXCEPTION("구입금액의 형식이 맞지 않습니다."),
    LOTTO_MIN_LIMIT_EXCEPTION("로또를 구입하게 위해서 ${LottoPurchase.LOTTO_PRICE}원 보다 커야 합니다."),
    LOTTO_PRICE_UNIT_EXCEPTION("로또의 구입금액 ${LottoPurchase.LOTTO_PRICE}원과 맞지 않습니다."),
    LOTTO_NUMBERS_INPUT_FORMAT_EXCEPTION("로또번호 입력 형식이 맞지 않습니다."),
    LOTTO_NUMBERS_COUNT_EXCEPTION("로또 숫자 개수가 ${LottoGenerator.LOTTO_NUMBER_COUNT}개가 아닙니다")
}
