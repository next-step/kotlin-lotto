package lotto

object Const {
    object OutputMsg {
        const val GET_PRICE_MSG = "구입금액을 입력해 주세요."
        const val LOTTO_NUM_MSG = "지난 주 당첨 번호를 입력해 주세요."
    }

    object ErrorMsg {
        const val INPUT_VALUE_IS_NULL_ERROR = "입력한 값이 비어있습니다."
        const val INPUT_VALUE_IS_NOT_INT_ERROR = "입력한 값이 정수가 아닙니다."
        const val INPUT_VALUE_CANNOT_CONVERSE_LOTTO_PRICE_ERROR = "입력한 값으로는 구매가 불가능합니다."
        const val INPUT_VALUE_CANNOT_CONVERSE_LOTTO_WINNING_NUMBER_ERROR = "지난주 당첨번호를 잘못 입력하셨습니다."
    }
}
