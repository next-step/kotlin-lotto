package lotto.util

import lotto.domain.Lotto
import lotto.domain.LottoNumber
import lotto.domain.LottoPurchase

enum class ErrorCode(val errorMessage: String) {
    MONEY_INPUT_FORMAT_EXCEPTION("구입금액의 형식이 맞지 않습니다."),
    LOTTO_MIN_LIMIT_EXCEPTION("로또를 구입하게 위해서 ${LottoPurchase.LOTTO_PRICE}원 보다 커야 합니다."),
    LOTTO_PRICE_UNIT_EXCEPTION("로또의 구입금액 ${LottoPurchase.LOTTO_PRICE}원과 맞지 않습니다."),
    LOTTO_NUMBERS_INPUT_FORMAT_EXCEPTION("로또번호 입력 형식이 맞지 않습니다."),
    LOTTO_NUMBERS_COUNT_EXCEPTION("로또 숫자 개수가 ${Lotto.LOTTO_NUMBER_COUNT}개가 아닙니다"),
    LOTTO_NUMBER_EXEPTION(
        "로또의 숫자는 ${LottoNumber.LOTTO_START_NUMBER} ~ ${LottoNumber.LOTTO_END_NUMBER} 사이 숫자만 가능합니다."
    ),
    NUMBER_EXCEPTION("숫자만 입력 가능합니다."),
    BONUS_LOTTO_NUMBER_EXCEPTION("보너스 볼은 당첨번호와 같을 수 없습니다.")
}
