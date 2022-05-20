package calculator

object Const {
    object OutputMsg {
        const val APPLICATION_START_MSG =
            "쉼표(,) 또는 콜론(:)을 구분자를 기준으로 분리한 숫자의 총합이 계산됩니다.\n예시) => 0, \"1,2\" => 3, \"1,2,3\" => 6, \"1,2:3\" => 6"
    }

    object ErrorMsg {
        const val INPUT_IS_NOT_POSITIVE_NUMBER_ERROR_MSG = "0이나 양수가 아닌 값이 들어있습니다."
    }
}
