package lotto.data

import java.util.TreeSet

data class Lotto(val selectNumberList: TreeSet<Int>) {

    init {
        selectNumberList.forEach { LottoNumber.validateRange(it) }
        require(selectNumberList.size == LOTTO_NUMBER_COUNT) { ERR_MSG_INVALID_LOTTO_NUMBER_COUNT }
    }

    companion object {
        private const val ERR_MSG_INVALID_LOTTO_NUMBER_COUNT = "로또번호는 6개로 구성되어야 합니다. 중복된 숫자는 불가합니다."
        private const val LOTTO_NUMBER_COUNT = 6
    }
}
