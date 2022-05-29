package lotto

import lotto.domain.LottoPurchase

object Const {
    object OutputMsg {
        const val GET_PRICE_MSG = "구입금액을 입력해 주세요."
        const val LOTTO_NUM_MSG = "지난 주 당첨 번호를 입력해 주세요."
    }

    object ErrorMsg {
        const val INPUT_VALUE_IS_NULL_ERROR_MSG = "입력한 값이 비어있습니다."
        const val INPUT_VALUE_IS_NOT_INT_ERROR_MSG = "입력한 값이 정수가 아닙니다."
        const val INPUT_VALUE_CANNOT_CONVERSE_LOTTO_PRICE_ERROR_MSG = "입력한 값으로는 구매가 불가능합니다. 로또 한개의 가격은 ${LottoPurchase.LOTTO_PRICE}원 입니다."
        const val INPUT_VALUE_CANNOT_CONVERSE_LOTTO_WINNING_NUMBER_ERROR_MSG = "지난주 당첨번호를 잘못 입력하셨습니다."
        const val INVALID_BONUS_NUMBER_ERROR_MSG = "보너스 번호는 당첨 번호와 중복될 수 없습니다."
        const val CANNOT_CONVERSE_LOTTO_NUMBER_ERROR_MSG = "로또 번호가 아닙니다."
        const val LOTTO_TICKET_NUMBER_IS_NOT_6_ERROR_MSG = "로또는 6개의 숫자로 이루어져 있습니다."
    }
}
